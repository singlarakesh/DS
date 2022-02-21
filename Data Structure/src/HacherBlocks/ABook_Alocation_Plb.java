package HacherBlocks;

import java.util.Scanner;

public class ABook_Alocation_Plb {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scr.nextInt();
		}
		int reader = scr.nextInt();
		min_of_max_pages(a, reader);
	}

	private static void min_of_max_pages(int[] pages, int reader) {
		int min = 0;
		int max = 0;
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < pages.length; i++) {
			max += pages[i];
			if (min < pages[i]) {
				min = pages[i];
			}
		}
		while (min <= max) {
			int mid = (min + max) / 2;
			if (isFeasible(pages, mid, reader)) {
				result = mid;
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}
		System.out.println(result);
	}

	private static boolean isFeasible(int[] pages, int mid, int reader) {
		int sum = 0;
		int k = 1;
		for (int i = 0; i < pages.length; i++) {
			sum += pages[i];
			if (sum > mid) {
				sum = pages[i];
				k++;
			}
		}
		if (k == reader) {
			return true;
		} else {
			return false;
		}
	}
}
