package dp;

public class CombinationSumIV {
	public static void main(String[] args) {
		int nums[] = { 1, 2, 3 };
		int target = 4;
		System.out.println(combine(nums, target, 0));
	}

	public static int combine(int[] nums, int target, int i) {
		if (target == 0)
			return 1;
		if (i >= nums.length)
			return 0;
		if (target - nums[i] >= 0) {
			return combine(nums, target - nums[i], i) + combine(nums, target, i + 1);

		} else {

			return combine(nums, target, i + 1);
		}

	}
}
