package dp;

import java.util.Scanner;

public class Min_Cost_Climbing_Stairs {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int cost[] = new int[n];
		for (int i = 0; i < n; i++) {
			cost[i] = scr.nextInt();
		}
		int dp[] = new int[n];
		for(int i=n-1;i>=0;i--) {
			if(i+1>=n||i+2>=n) {
				dp[i]=cost[i];
			}else {
				int min=Math.min(dp[i+1], dp[i+2]);
				cost[i]+=min;
			}
		}
	}
}
