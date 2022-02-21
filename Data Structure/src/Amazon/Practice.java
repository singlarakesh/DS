package Amazon;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Practice {
	public static void main(String[] args) {
		int points[][] = { { 1, 3 }, { -2, 2 } };
		int k = 1;
		kPointsFromOrigin(points, k);
	}

	private static void kPointsFromOrigin(int[][] points, int k) {
		// TODO Auto-generated method stub
		Queue<Node> q = new PriorityQueue<>(new Node());
		for (int i = 0; i < points.length; i++) {
			int x = points[i][0];
			int y = points[i][1];
			int dist = (int) (Math.pow(x, 2) + Math.pow(y, 2));
			Node nn = new Node(dist, points[i]);
			q.add(nn);
		}
	}

	static class Node implements Comparator<Node> {
		public Node(int dist, int[] pt) {
			super();
			this.dist = dist;
			this.pt = pt;
		}

		Node() {
		}

		int dist;
		int pt[];

		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			int dist = o1.dist - o2.dist;
			if (dist == 0)
				return o1.pt[0] - o2.pt[0];
			return dist;
		}

	}
}
