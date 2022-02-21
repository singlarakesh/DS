package slidingWindow;

import java.util.Deque;
import java.util.LinkedList;

public class FirstNegativeInWind {
	public static void main(String[] args) {
		int ar[] = { -8, 2, 3, -6, 10 };
		int k = 2;
		findMax(ar, k);
	}

	private static void findMax(int[] ar, int k) {
		// TODO Auto-generated method stub
		Deque<Integer> q = new LinkedList<Integer>();
		int ans[] = new int[ar.length - k + 1];
		int c = 1;
		int i = 0;

		for (i = 0; i < ar.length && c <= k; i++) {
//			while (!q.isEmpty() && ar[q.peekLast()] < ar[i]) {
//				q.removeLast();
//			}
			if (ar[i] < 0)
				q.addLast(i);
			c++;
		}
		int t = 0;
		while (i < ar.length) {
			if (!q.isEmpty()) {
				ans[t] = ar[q.peekFirst()];
			} else {
				ans[t] = 0;
			}
			while (!q.isEmpty() && q.peekFirst() <= i - k) {
				q.removeFirst();
			}
//			while (!q.isEmpty() && ar[q.peekLast()] < ar[i]) {
//				q.removeLast();
//			}
			if (ar[i] < 0)
				q.addLast(i);
			i++;
			t++;
		}
		if (!q.isEmpty()) {
			ans[t] = ar[q.peekFirst()];

		}
		for(int l:ans) {
			System.out.println(l);
		}
	}
}
