package dp;

import java.util.LinkedList;
import java.util.List;

public class LargestNumber {
	public static void main(String[] args) {
		int nums[] = { 3, 30, 34, 5, 9 };
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length - i - 1; j++) {
				if(cmp(nums,i,j)) {
					int temp=nums[i];
					nums[i]=nums[j];
					nums[j]=temp;
				}
			}
		}
	}

	private static boolean cmp(int[] nums, int i, int j) {
		// TODO Auto-generated method stub
		List<List<Integer>> rooms=new LinkedList<List<Integer>>();
		rooms.get(i);
		return false;
	}
}
