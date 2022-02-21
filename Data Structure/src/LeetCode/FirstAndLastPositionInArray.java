package LeetCode;

public class FirstAndLastPositionInArray {
	public static void main(String[] args) {
		int nums[] = { 5, 7, 7, 8, 10 };
		int target = 8;
		int res[] = new int[2];
		res[0] = findFirstOcc(nums, target);
		res[1] = findLastOcc(nums, target);
		for (int i = 0; i < res.length; i++)
			System.out.println(res[i]);
	}

	private static int findFirstOcc(int[] nums, int target) {
		// TODO Auto-generated method stub
		int lb = 0;
		int ub = nums.length - 1;
		int ans = -1;
		while (lb <= ub) {
			int mid = (lb + ub) / 2;
			if (nums[mid] == target) {
				ans = mid;
				ub = mid - 1;
			} else if (nums[mid] > target) {
				ub = mid - 1;
			} else {
				lb = mid + 1;
			}
		}
		return ans;
	}

	private static int findLastOcc(int[] nums, int target) {
		// TODO Auto-generated method stub
		int lb = 0;
		int ub = nums.length - 1;
		int ans = -1;
		while (lb <= ub) {
			int mid = (lb + ub) / 2;
			if (nums[mid] == target) {
				ans = mid;
				lb = mid + 1;
			} else if (nums[mid] > target) {
				ub = mid - 1;
			} else {
				lb = mid + 1;
			}
		}
		return ans;
	}
}
