package LeetCode;

public class Peak_Element {
	public static void main(String[] args) {
		int nums[] = { 4, 5, 6, 7, 0, 1, 2 };
		int lind = findpeekIndex(nums);
		System.out.println(lind);
	}

	private static int findpeekIndex(int[] nums) {
		// TODO Auto-generated method stub
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
	}
}
