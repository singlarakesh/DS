package LeetCode;

public class PairOfSongs_1010 {
	public static void main(String[] args) {
		int time[] = { 1, 2, 3 };
		System.out.println(numPairsDivisibleBy60(time, 4));
	}

	public static int numPairsDivisibleBy60(int[] nums, int target) {
		int dp[][] = new int[nums.length + 1][target + 1];
		dp[0][0] = 1;
		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = 1;
		}
		for (int j = 1; j <= target; j++) {
			dp[0][j] = 0;
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j <= target; j++) {
				if (nums[i - 1] <= j)
					dp[i][j] = dp[i - 1][j] + dp[i][j - nums[i - 1]];
				else
					dp[i][j] = dp[i - 1][j];
			}
		}
		return dp[nums.length][target];
	}
}
