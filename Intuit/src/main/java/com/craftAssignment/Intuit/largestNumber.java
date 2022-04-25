package com.craftAssignment.Intuit;

public class largestNumber {
	public static void main(String[] args) {
		String nums[] = { "10", "2" };
		formBiggestNumber(nums);
	}

	private static void formBiggestNumber(String[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = 0; j < nums.length - i - 1; j++) {
				if (compare(nums[j], nums[j + 1])) {
					String temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
			}
		}
		String ans = "";
		for (int i = 0; i < nums.length; i++) {
			ans = nums[i] + ans;
		}
		System.out.println(ans);
	}

	private static boolean compare(String a, String b) {
		// TODO Auto-generated method stub
		int i = 0;
		int j = 0;
		while (i < a.length() && j < b.length()) {
			if (a.charAt(i) > b.charAt(j)) {
				return true;
			} else if (a.charAt(i) < b.charAt(j)) {
				return false;
			} else {
				i++;
				j++;
			}
		}
		if (i < a.length() && b.charAt(j - 1) < a.charAt(i)) {
			return true;
		}
		if (j < b.length() && a.charAt(i - 1) > b.charAt(j)) {
			return true;
		}
		return false;
	}
}
