package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

public class HouseRobber {
	public static void main(String[] args) {
		int nums[] = { 2,2,3,3,3,4 };
		int capacity = 4;
		int dp[] = new int[nums.length];
//		System.out.println(moneyToRob(nums, 0, dp));
//		using tabulation
		System.out.println(deleteEarn(nums));
	}

	private static int deleteEarn(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		ArrayList<Integer> arr=new ArrayList<Integer>();
		for (int i : nums) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
				arr.add(i);
			}
		}
		int dp[][] = new int[2][arr.size()+1];
		for (int i = 1; i <= arr.size(); i++) {
			dp[0][i]=Math.max(dp[0][i-1], dp[1][i-1]);
			dp[1][i]=map.get(arr.get(i-1))*arr.get(i-1)+dp[0][i-1];
		}
		return Math.max(dp[0][ arr.size()], dp[1][ arr.size()]);
	}

	public int rob(int[] num) {
		int[][] dp = new int[num.length + 1][2];
		for (int i = 1; i <= num.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
			dp[i][1] = num[i - 1] + dp[i - 1][0];
		}
		return Math.max(dp[num.length][0], dp[num.length][1]);
	}

	private static int moneyToRob(int[] nums) {
		// TODO Auto-generated method stub
		if (nums.length == 1)
			return nums[0];
		int dp[] = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = nums[1];
		for (int i = 2; i < nums.length; i++) {
			int tempMax = Integer.MIN_VALUE;
			for (int j = i - 2; j >= 0; j--) {
				tempMax = tempMax < dp[j] ? dp[j] : tempMax;
			}
			dp[i] = nums[i] + tempMax;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > max) {
				max = dp[i];
			}
		}
		return max;
	}

	private static int moneyToRob(int[] nums, int i, int[] dp) {
		// TODO Auto-generated method stub
		if (i >= nums.length) {
			return 0;
		}
		if (dp[i] != 0) {
			return dp[i];
		}
		dp[i] = Math.max(moneyToRob(nums, i + 2, dp) + nums[i], moneyToRob(nums, i + 1, dp));
		return dp[i];

	}
}
