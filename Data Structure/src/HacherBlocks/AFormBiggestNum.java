package HacherBlocks;

import java.util.Scanner;

public class AFormBiggestNum {
	static Scanner scr = new Scanner(System.in);

	public static void main(String args[]) {
		String array[] = null;
		int tc = scr.nextInt();
		for (int i = 0; i < tc; i++) {
			int n = scr.nextInt();
			array = new String[n];
			for (int j = 0; j < n; j++)
				array[j] = Integer.toString(scr.nextInt());

			bubbleSort(array);

			for (String val : array) {
				System.out.print(val);

			}
			System.out.println();
		}
	}

	public static void bubbleSort(String[] arr) {

		int n = arr.length;
		for (int counter = 0; counter < n - 1; counter++) {

			for (int j = 0; j < n - 1 - counter; j++) {

				if (compare(arr[j], arr[j + 1]) > 0) {
					String temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

			}

		}

	}

	// +ve value then swap
	public static int compare(String str1, String str2) {

		int i = 0;
		int j = 0;

		while (i < str1.length() && j < str2.length()) {

			if (str1.charAt(i) != str2.charAt(j)) {
				return str2.charAt(i) - str1.charAt(j);
			} else {

				i++;
				j++;
			}
		}

		if (i == str1.length() && j < str2.length()) {
			char lc = str2.charAt(j);
			char ls = str2.charAt(j - 1);

			if (lc > ls) {
				return 1;
			} else {
				return -1;
			}
		}

		if (j == str2.length() && i < str1.length()) {
			char lc = str1.charAt(i);
			char ls = str1.charAt(i - 1);

			if (lc > ls) {
				return -1;
			} else {
				return 1;
			}
		}

		return 0;
	}
}