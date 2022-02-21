package HacherBlocks;

import java.util.Scanner;

public class NthFib {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int dp[] = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		System.out.println(dp[n]);
	}
}
