package Matrix;

public class UniquePath2 {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 0 } };
		System.out.println(obstacleGrid(matrix));
	}

	private static int obstacleGrid(int[][] matrix) {
		// TODO Auto-generated method stub
		if (matrix[0][0] == 1)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int dp[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
						dp[i][j] = 1;
				} else if (i == 0) {
					if (matrix[i][j] != 1 && dp[i][j-1]!=0) {
						dp[i][j] = 1;
					}
				} else if (j == 0) {
					if (matrix[i][j] != 1 && dp[i-1][j]!=0) {
						dp[i][j] = 1;
					}
				} else {
					if (matrix[i][j] != 1)
						dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(dp[i][j]);
			}
			System.out.println();
		}
		return dp[m - 1][n - 1];
	}
}
