package dp;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int coin[] = { 1, 2, 5 };
		int amt = 5;
		// recursion
//		System.out.println(minCoinNeeded(coin, 0, amt));
		// dp
		System.out.println(minCoinNeededDp(coin, amt));
	}

	private static int minCoinNeededDp(int[] coin, int amt) {
		// TODO Auto-generated method stub
		int[][] dp = new int[coin.length + 1][amt + 1];
		dp[0][0] = 0;
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;
		}
		for (int j = 1; j < dp[0].length; j++) {
			dp[0][j] = Integer.MAX_VALUE;
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (j - coin[i - 1] >= 0) {
					int x = 0;
					if (dp[i][j - coin[i - 1]] != Integer.MAX_VALUE)
						x = dp[i][j - coin[i - 1]];
					int y = dp[i - 1][j];
					if (y != Integer.MAX_VALUE)
						x += y;
					dp[i][j] =x ;
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[dp.length - 1][dp[0].length - 1];
	}

	public static int minCoinNeeded(int coin[], int i, int amt) {
		if (amt == 0) {
			return 0;
		}
		if (i >= coin.length)
			return Integer.MAX_VALUE;

		if (amt - coin[i] >= 0) {
			int x = minCoinNeeded(coin, i, amt - coin[i]);
			if (x != Integer.MAX_VALUE) {
				x += 1;
			}
			return Math.min(x, minCoinNeeded(coin, i + 1, amt));
		} else {

			return minCoinNeeded(coin, i + 1, amt);
		}
	}

}
