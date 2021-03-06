package HacherBlocks;

import java.util.Scanner;

public class MinJumpsNeeded {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int tc = scr.nextInt();
		for (int i = 0; i < tc; i++) {
			int n = scr.nextInt();
			int a[] = new int[n];
			for (int j = 0; j < n; j++) {
				a[j] = scr.nextInt();
			}
			minJumpsReq(a, n);
		}
	}

	private static void minJumpsReq(int[] a, int n) {
		// TODO Auto-generated method stub
		int dp[] = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			if (a[i] + i >= n - 1) {
				dp[i] = 1;
			} else {
				int min = Integer.MAX_VALUE;
				for (int j = 1; j <= a[i] && i + j < n; j++) {
					min = Math.min(min, dp[i + j]);
				}
				if (min != Integer.MAX_VALUE) {
					dp[i] = min + 1;
				} else {
					dp[i] = min;
				}
			}
		}
		System.out.println(dp[0]);
	}
}
