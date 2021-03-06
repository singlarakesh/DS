package dp;

import java.util.Scanner;

public class subset_sum_to_target {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int target = scr.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scr.nextInt();
		}
		return findSum(a, target);
	}

		private static boolean findSum(int[] a, int target) {
			boolean dp[][] = new boolean[a.length][target + 1];
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j <= target; j++) {
					if (j == 0) {
						dp[i][j] = true;
					} else if (i == 0) {
						dp[i][j] = (a[i] == j) ? true : false;
					} else {
						dp[i][j] = ((a[i] == j)||dp[i-1][j]|| (j - a[i] >= 0 && dp[i - 1][j - a[i]])) ? true : false;
					}
				}
			}
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j <= target; j++) {
					System.out.print(dp[i][j] + " ");
				}
				System.out.println();
			}
			return dp[a.length - 1][target];
	}
}
