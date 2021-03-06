package Amazon;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Node implements Comparator<Node> {
	int dist;
	int[] pt;

	Node() {
	}

	Node(int dist, int[] pt) {
		this.dist = dist;
		this.pt = pt;
	}

	@Override
	public int compare(Node o1, Node o2) {
		// TODO Auto-generated method stub
		int dist= o1.dist - o2.dist;
        if(dist==0){
         return o1.pt[0]-o2.pt[0];
        }
        return dist;
	}

}

public class kClosest {
	public static void main(String[] args) {
		int[][] ar = { { 1, 0 }, { -1, 0 } };
		kclosest(ar, 1);
	}

	private static void kclosest(int[][] ar, int k) {
		// TODO Auto-generated method stub
		Queue<Node> q = new PriorityQueue<>(new Node());
		for (int l = 0; l < ar.length; l++) {

			int i = ar[l][0];
			int j = ar[l][1];
			int s = i * i + j * j;
			Node nn = new Node(s, ar[l]);
			q.add(nn);
		}
		int[][] res = new int[k][2];
		while (k > 0) {
			res[--k] = q.poll().pt;
		}
		for (int l = 0; l < res.length; l++) {
			System.out.println(res[l][0] + "," + res[l][1]);
		}

	}
}
