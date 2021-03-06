package dp;

public class Climbing_Stairs {
	public static void main(String[] args) {
		climbStairs(5);
	}

	public static int climbStairs(int n) {
		int dp[] = new int[n + 1];
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			if (i == 1) {
				dp[i] = dp[i - 1];
			} else if (i == 2) {
				dp[i] = dp[i - 1] + dp[i - 2];
			} else {
				dp[i] = dp[i - 1] + dp[i - 2]+ dp[i - 3];
			}
		}
		System.out.println(dp[n]);
		return dp[n];
//		if (n == 0)
//			return 1;
//		if (n < 0)
//			return 0;
//		int c1 = climbStairs(n - 1);
//		int c2 = climbStairs(n - 2);
//		return c1 + c2;
	}

	public int climbStairs(int n, int dp[]) {
		if (n == 0)
			return 1;
		if (n < 0)
			return 0;
		if (dp[n] != 0)
			return dp[n];
		int c1 = climbStairs(n - 1);
		int c2 = climbStairs(n - 2);
		dp[n] = c1 + c2;
		return c1 + c2;
	}
}
