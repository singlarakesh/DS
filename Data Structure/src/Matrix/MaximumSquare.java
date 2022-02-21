package Matrix;

public class MaximumSquare {
	public static void main(String[] args) {
		String ar[][] = { { "1", "0", "1", "0", "0" }, { "1", "0", "1", "1", "1" }, { "1", "1", "1", "1", "1" },
				{ "1", "0", "0", "1", "0" } };
		System.out.println(maximumSquare(ar));
	}

	private static int maximumSquare(String[][] ar) {
		// TODO Auto-generated method stub
		int maxLength=0;
		int dp[][]=new int[ar.length][ar[0].length];
		for (int i = ar.length - 2; i >= 0; i--) {
			for (int j = ar[0].length-2; j >= 0; j--) {
				if(ar[i][j]=="1") {
					dp[i][j]=Math.min(Math.min(dp[i+1][j], dp[i][j+1]), dp[i+1][j+1])+1;
					maxLength=Math.max(maxLength, dp[i][j]);
				}
			}
		}
		return maxLength*maxLength;
	}
}
