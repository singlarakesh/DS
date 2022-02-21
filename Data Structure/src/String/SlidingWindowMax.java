package String;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

//0(N)
public class SlidingWindowMax {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scr.nextInt();
		}
//		Window size
		int k = scr.nextInt();
		slidingWindowMax(a, k);
	}

//Deque Method
	private static void slidingWindowMax(int[] a, int k) {
		// TODO Auto-generated method stub
		Deque<Integer> q = new LinkedList<Integer>();
		int i = 0;
		for (; i < k; i++) {
			while (!q.isEmpty() && a[i] > a[q.peekLast()])
				q.removeLast();
			q.addLast(i);
		}
		for (; i < a.length; ++i) {
			System.out.println(a[q.peek()]);
			while (!q.isEmpty() && q.peek() <= i - k)
				q.removeFirst();

			while (!q.isEmpty() && a[i] >= a[q.peekLast()])
				q.removeLast();
			q.addLast(i);
		}

		System.out.println(a[q.peek()]);
	}
}
