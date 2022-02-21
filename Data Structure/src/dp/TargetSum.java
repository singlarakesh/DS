package dp;

import java.util.Scanner;

public class TargetSum {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scr.nextInt();
		}
		int targetSum = scr.nextInt();
		  int sum = 0;
			int dif = targetSum;
	        int number_of_0s=0;
			for (int i = 0; i < a.length; i++) {
				sum += a[i];
	            if(a[i]==0){
	                number_of_0s+=1;}
			}
	        if(dif>sum ||  (sum + dif) % 2 != 0){
//	            return 0;
	        }
			int target = (sum + dif) / 2;
			int dp[][] = new int[a.length + 1][target + 1];
			for (int i = 0; i <= a.length; i++) {
				dp[i][0] = 1;
			}
			for (int j = 1; j <= target; j++) {
				dp[0][j] = 0;
			}
			for (int i = 1; i <= a.length; i++) {
				for (int j = 1; j <= target; j++) {
	              if(a[i-1]==0){
	                    dp[i][j] = dp[i-1][j];
	              }else if (a[i - 1] <= j) {
						dp[i][j] = dp[i - 1][j] + dp[i - 1][j - a[i - 1]];
					} else {
						dp[i][j] = dp[i - 1][j];
					}
				}
			}
//			return (int)Math.pow(2, number_of_0s)*dp[a.length][target];
		System.out.println((int)Math.pow(2, number_of_0s)*dp[a.length][target]);
	}
}
