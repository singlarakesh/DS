package HacherBlocks;

import java.util.Scanner;

public class AMaxSubsetO1 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int tc = sc.nextInt();
		for (int i = 0; i < tc; i++) {
			int[] arr = takeInput();
			maxSubarray(arr);
		}
	}

	public static int[] takeInput() {
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int j = 0; j < arr.length; j++) {
			arr[j] = sc.nextInt();
		}
		return arr;
	}

	public static void maxSubarray(int[] arr) {
		int l = arr.length;
		int maxCount = -1, sIndex = 0, eIndex = 0;
		for (int i = 0; i < l; i++) {
			int zero = 0, one = 0;
			int endIndex = i;

			for (; endIndex < l; endIndex++) {
				if (arr[endIndex] == 0)
					zero++;
				else if (arr[endIndex] == 1)
					one++;

				if (zero == one) {
					if (zero > maxCount) {
						maxCount = zero;
						sIndex = i;
						eIndex = endIndex;
					}
				}
			}
		}
		if (maxCount == -1) {
			System.out.println("None");
		} else {
			System.out.println(sIndex + " " + eIndex);
		}
	}
}
