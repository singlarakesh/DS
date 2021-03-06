package HacherBlocks;

import java.util.Scanner;

public class EqualizeString {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		String s1 = scr.next();
		String s2 = scr.next();
		equalizeString(s1, s2);
	}

	private static void equalizeString(String s1, String s2) {
		// TODO Auto-generated method stub
		int m = s1.length();
		int n = s2.length();
		int dp[][] = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0) {
					dp[i][j] = j;
				} else if (j == 0) {
					dp[i][j] = i;
				} else if (s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = dp[i - 1][j - 1];
				}else {
					int ins=dp[i][j-1];
					int del=dp[i-1][j];
					int rep=dp[i-1][j-1];
					dp[i][j]=Math.min(ins,Math.min(del, rep))+1;
				}
			}
		}
		System.out.println(dp[m][n]);
	}
}
