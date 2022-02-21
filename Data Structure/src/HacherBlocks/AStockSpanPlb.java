package HacherBlocks;

import java.util.Scanner;
import java.util.Stack;

public class AStockSpanPlb {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int tc = scr.nextInt();
		while (tc-- > 0) {
			int n = scr.nextInt();
			int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = scr.nextInt();
			}
			stockSpanPlb(a);
		}
	}

	private static void stockSpanPlb(int[] a) {
		Stack<Integer> s = new Stack<>();
		int ans[] = new int[a.length];
		s.push(0);
		ans[0] = 1;
		for (int i = 1; i < ans.length; i++) {
			while (!s.isEmpty() && a[i] > a[s.peek()]) {
				s.pop();
			}
			if (!s.isEmpty()) {
				ans[i] = i - s.peek();
			} else {
				ans[i] = i + 1;
			}
			s.push(i);

		}
		for (int i : ans) {
			System.out.print(i + " ");
		}
	}
}
