package dp;

public class RodCuttingPlb {
	public static void main(String[] args) {
		int price[] = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
		int n = price.length;
//		rodCutPlb(price, n, 0);
		rodCutPlbDp(price, n);
	}

	private static int rodCutPlb(int[] price, int n, int i) {
		// TODO Auto-generated method stub
		if (n == 0 || price.length == i) {
			return 0;
		}
		if (n - (i + 1) >= 0)
			return Math.max(rodCutPlb(price, n - (i + 1), i) + price[i], rodCutPlb(price, n, i + 1));
		else
			return rodCutPlb(price, n, i + 1);
	}

	private static void rodCutPlbDp(int[] price, int n) {
		// TODO Auto-generated method stub
		System.out.println(n);
		int dp[][] = new int[n + 1][n + 1];
System.out.println(dp.length);
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else {
					if (j - i >= 0) {
						dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - i] + price[i - 1]);
					} else {
						dp[i][j] = dp[i - 1][j];
					}

				}

			}
		}
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				System.out.print(dp[i][j] + " ");

			}
			System.out.println();
		}
		System.out.println(dp[n][n]);
	}
}
