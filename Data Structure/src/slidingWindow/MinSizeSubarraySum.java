package slidingWindow;

public class MinSizeSubarraySum {
	public static void main(String[] args) {
		int target = 4;
		int nums[] = { 1, 4, 4 };
		minSize(nums, target);
	}

	private static void minSize(int[] nums, int target) {
		// TODO Auto-generated method stub
		int i = 0;
		int j = 0;
		int cal = 0;
		int ans = Integer.MAX_VALUE;
		while (i <= j && j < nums.length) {
			cal += nums[j];
			if (cal < target) {
				j++;
			} else if (cal == target) {
				System.out.println("I am here");
				int s = j - i + 1;
				ans = ans > s ? s : ans;
			} else {
				cal -= nums[i];
				i++;
			}
		}
		System.out.println(ans);
	}
}
