package Amazon;

public class MaximumProductSubarray {
	public static void main(String[] args) {
		int nums[] = { 2, 3, -2, 4 };
		maxProduct(nums);
	}

	public static int maxProduct(int[] nums) {
//		int maxProduct = Integer.MIN_VALUE;
//		for (int i = 0; i < nums.length; i++) {
//			int product = nums[i];
//			if (product > maxProduct) {
//				maxProduct = product;
//			}
//			for (int j = i + 1; j < nums.length; j++) {
//				product *= nums[j];
//				if (product > maxProduct) {
//					maxProduct = product;
//				}
//			}
//		}
//		return maxProduct;
		  int n = nums.length, res = nums[0], l = 0, r = 0;
	        for (int i = 0; i < n; i++) {
	            l =  (l == 0 ? 1 : l) * nums[i];
	            r =  (r == 0 ? 1 : r) * nums[n - 1 - i];
	            res = Math.max(res, Math.max(l, r));
	        }
	        return res;
	}
}
