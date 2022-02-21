package dp;

public class MaximumProductSubArray {
	public static void main(String[] args) {
		int nums[] = {-2,0,-1};
		int maxSuffix = 1;
		int maxPrefix = 1;
		int ans = nums[0];
		for (int i = 0, j = nums.length-1; i < nums.length && j >= 0; i++, j--) {
			if(maxPrefix==0) {
				maxPrefix=1;
				maxPrefix*=nums[i];
			}else {
				maxPrefix*=nums[i];
			}
			if(maxSuffix==0) {
				maxSuffix=1;
				maxSuffix*=nums[i];
			}else {
				maxSuffix*=nums[j];
			}
			ans=Math.max(ans, Math.max(maxPrefix, maxSuffix));
		}
		System.out.println(ans);
	}
}
