package com.craftAssignment.Intuit;

import java.util.Arrays;

public class KnapSack {
	public static void main(String[] args) {
		int wt[] = { 1, 2, 3 };
		int profit[] = { 10, 15, 40 };
		int capacity = 6;
		int dp[] = new int[wt.length];
		Arrays.fill(dp, -1);
		System.out.println(maxProfit(wt, profit, capacity, 0, dp));
	}

	private static int maxProfit(int[] wt, int[] profit, int capacity, int i, int[] dp) {
		if (i >= wt.length) {
			return 0;
		}
		if (dp[i] != -1) {
			return dp[i];
		}
		if (wt[i] <= capacity) {
			int include = maxProfit(wt, profit, capacity, i + 1, dp) + profit[i];
			int exclude = maxProfit(wt, profit, capacity, i + 1, dp);
			dp[i] = Math.max(include, exclude);
			return dp[i];
		} else {
			dp[i] = maxProfit(wt, profit, capacity, i + 1, dp);
			return dp[i];
		}

	}
}
