package Matrix;

public class UniquePath {
	public static void main(String[] args) {
		int m = 3;
		int n = 7;
//		findUniquePath(0, 0, m - 1, n - 1);
		System.out.println(findUniquePath(0, 0, m - 1, n - 1));
		System.out.println(dpFindUniquePath(m, n));
	}

	private static int dpFindUniquePath(int m, int n) {
		// TODO Auto-generated method stub
		int dp[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		return dp[m - 1][n - 1];
	}

	private static int findUniquePath(int i, int j, int m, int n) {
		// TODO Auto-generated method stub
		if (i == m && j == n) {
			return 1;
		}
		int pathCount = 0;
		if (i <= m)
			pathCount += findUniquePath(i + 1, j, m, n);
		if (j <= n)
			pathCount += findUniquePath(i, j + 1, m, n);
		return pathCount;
	}
}
