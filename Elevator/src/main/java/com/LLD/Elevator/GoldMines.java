package com.LLD.Elevator;

public class GoldMines {
	public static void main(String[] args) {
		int mat[][] = { { 10, 33, 13, 15 }, { 22, 21, 04, 1 }, { 5, 0, 2, 3 }, { 0, 6, 14, 2 } };
		;
		goldMines(mat);
	}

	private static void goldMines(int[][] mat) {
		// TODO Auto-generated method stub
		int dp[][] = new int[mat.length][mat[0].length];
		for (int i = 0; i < mat.length; i++) {
			dp[i][mat[0].length - 1] = mat[i][mat[0].length - 1];
		}
		for (int j = mat[0].length - 2; j >= 0; j--) {
			for (int i = 0; i < mat.length; i++) {
				int max = Integer.MIN_VALUE;
				if (isValid(dp, i - 1, j + 1)) {
					max = Math.max(max, dp[i - 1][j + 1]);
				}
				if (isValid(dp, i + 1, j + 1)) {
					max = Math.max(max, dp[i + 1][j + 1]);
				}
				if (isValid(dp, i, j + 1)) {
					max = Math.max(max, dp[i][j + 1]);
				}
				dp[i][j] = mat[i][j] + max;
			}
		}
	
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(dp[i][j]);
			}
			System.out.println();
		}
	}

	private static boolean isValid(int[][] dp, int i, int j) {
		// TODO Auto-generated method stub
		if (i < 0 || i >= dp.length || j < 0 || j >= dp[0].length) {
			return false;
		}
		return true;
	}
}
