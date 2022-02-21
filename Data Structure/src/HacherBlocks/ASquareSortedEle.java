package HacherBlocks;

import java.util.Scanner;

public class ASquareSortedEle {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int nums[] = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = scr.nextInt();
		}
		sortArr(nums);
	}

	private static void sortArr(int[] nums) {
		// TODO Auto-generated method stub
		int i = 0;
		int j = nums.length - 1;
		int res[] = new int[nums.length];
		int k = nums.length - 1;
		while (i < j) {
			if (Math.abs(nums[i]) < Math.abs(nums[j])) {
				res[k] = nums[j] * nums[j];
			} else {
				res[k] = nums[i] * nums[i];
			}
			k--;
		}
		for (i = 0; i < nums.length; i++) {
			System.out.println(res[i]);
		}
	}
}
