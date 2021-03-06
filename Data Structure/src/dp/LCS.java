package dp;

public class LCS {
	public static void main(String[] args) {
		String text1 = "abcde", text2 = "ace";
		System.out.println(lcs(text1, text2, 0, 0));
		System.out.println(lcsDp(text1, text2));
	}

	private static int lcsDp(String text1, String text2) {
		// TODO Auto-generated method stub
		int dp[][] = new int[text1.length() + 1][text2.length() + 1];
		for (int i = 0; i <= text1.length(); i++) {
			for (int j = 0; j <= text2.length(); j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else {
					if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
						dp[i][j] = dp[i - 1][j - 1] + 1;
					} else {
						dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
					}
				}
			}
		}
		return dp[text1.length()][text2.length()];
	}

	private static int lcs(String text1, String text2, int i, int j) {
		if (i == text1.length() || j == text2.length())
			return 0;
		if (text1.charAt(i) == text2.charAt(j)) {
			return lcs(text1, text2, i + 1, j + 1) + 1;
		} else {
			return Math.max(lcs(text1, text2, i, j + 1), lcs(text1, text2, i + 1, j));
		}
	}
}
