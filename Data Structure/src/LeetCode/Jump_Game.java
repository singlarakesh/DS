package LeetCode;

public class Jump_Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3,2,1,0,4};
		boolean dp[] = new boolean[nums.length];
		dp[nums.length - 1] = true;
		for (int i = nums.length - 2; i >= 0; i--) {
			for (int j = 1; j <= nums[i] && j + i <= nums.length - 1; j++) {
               if(dp[i+j]) {
            	   dp[i]=true;
               }
			}
		}
		System.out.println(dp[0]);
	}

}
