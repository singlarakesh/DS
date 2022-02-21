package HacherBlocks;

import java.util.Scanner;

public class ASubset_Plb {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int array[] = new int[n];
		for (int i = 0; i < array.length; i++) {

			array[i] = scr.nextInt();
		}

		int target = scr.nextInt();
//		findSubset(array, target, 0, 0);
		System.out.println(findSubset(array, target, 0, 0, ""));
	}

	private static int findSubset(int[] array, int target, int i, int sum, String ans) {
		// TODO Auto-generated method stub
		int c = 0;
		if (target == sum) {
			System.out.println(ans.split(""));
			return 1;
		}
		if (array.length == i)
			return 0;
		c += findSubset(array, target, i + 1, sum + array[i], ans+array[i]);
		c += findSubset(array, target, i + 1, sum, ans);
		return c;
	}
}
