import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Point {
	TNode node;
	int x;
	int y;

	public Point(TNode node, int x, int y) {
		super();
		this.node = node;
		this.x = x;
		this.y = y;
	}
}

public class Verticle {
	private static void verticleView(TNode root) {
		// TODO Auto-generated method stub
		Queue<Point> q = new LinkedList<Point>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Map<Integer, PriorityQueue<Point>> map = new HashMap<Integer, PriorityQueue<Point>>();
		q.offer(new Point(root, 0, 0));
		Comparator<Point> cmp = (a, b) -> {
			if (a.y == b.y) {
				return a.node.val - b.node.val;
			} else {
				return a.y - b.y;
			}
		};
		int max1 = 0;
		int min1 = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				Point rp = q.poll();
				root = rp.node;
				map.putIfAbsent(rp.x, new PriorityQueue<>(cmp));
				map.get(rp.x).add(rp);

				if (rp.node.left != null) {
					q.offer(new Point(rp.node.left, rp.x - 1, rp.y + 1));
				}
				if (rp.node.right != null) {
					q.offer(new Point(rp.node.right, rp.x + 1, rp.y + 1));
				}
				max1 = Math.max(max1, rp.x);
				min1 = Math.min(min1, rp.x);
			}
		}

		for (int i = min1;i<= max1; i++) {
			PriorityQueue<Point> p=map.get(i);
			List<Integer> l=new ArrayList<Integer>();
			while(!p.isEmpty()) {
				l.add(p.poll().node.val);
			}
			res.add(l);
		}
		System.out.println(res);
	}

}
