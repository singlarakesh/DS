package slidingWindow;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowMax {
	public static void main(String[] args) {
		int ar[] = { 1, -1 };
		int k = 1;
		findMax(ar, k);
	}

	private static void findMax(int[] ar, int k) {
		// TODO Auto-generated method stub
		Deque<Integer> q = new LinkedList<Integer>();
		int ans[] = new int[ar.length - k + 1];
		int c = 1;
		int i = 0;
		for (i = 0; i < ar.length && c <= k; i++) {
			while (!q.isEmpty() && ar[q.peekLast()] < ar[i]) {
				q.removeLast();
			}
			q.addLast(i);
			c++;
		}
		int t = 0;
		while (i < ar.length) {
			ans[t] = ar[q.peekFirst()];
			while (!q.isEmpty() && q.peekFirst() <= i - k) {
				q.removeFirst();
			}
			while (!q.isEmpty() && ar[q.peekLast()] < ar[i]) {
				q.removeLast();
			}
			q.addLast(i);
			i++;
			t++;
		}
		if (!q.isEmpty()) {
			ans[t] = ar[q.peekFirst()];

		}
	}
}
