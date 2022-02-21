package Matrix;

public class MinPathSum {

	public static void main(String[] args) {
		int cost[][] = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		int dp[][] = new int[cost.length][cost[0].length];
		int res = minathSum(cost, 0, 0, cost.length - 1, cost[0].length - 1, 0, dp);
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				System.out.print(dp[i][j]+ " ");
			}
			System.out.println();
		}
	}

	private static int minathSum(int[][] cost, int sr, int sc, int er, int ec, int ans, int[][] dp) {
		// TODO Auto-generated method stub
		if (sr == er && sc == ec) {
			dp[sr][sc]=cost[sr][sc];
			return dp[sr][sc];
		}
		if (dp[sr][sc] != 0) {
			return dp[sr][sc];
		}
		int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
		if (sc + 1 <= ec)
			a = minathSum(cost, sr, sc + 1, er, ec, ans + cost[sr][sc], dp)+ cost[sr][sc];
		if (sr + 1 <= er)
			b = minathSum(cost, sr + 1, sc, er, ec, ans + cost[sr][sc], dp)+ cost[sr][sc];
		dp[sr][sc] = Math.min(a, b);
		return dp[sr][sc];
	}

}
