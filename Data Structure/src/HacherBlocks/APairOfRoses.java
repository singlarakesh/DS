package HacherBlocks;

import java.util.Arrays;
import java.util.Scanner;

public class APairOfRoses {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int tc = scr.nextInt();
		for (int i = 0; i < tc; i++) {
			int n = scr.nextInt();
			int a[] = new int[n];
			for (int j = 0; j < n; j++) {
				a[j] = scr.nextInt();
			}
			int sum = scr.nextInt();
			Arrays.sort(a);
			findPairOfRoses(a, n, sum);
		}
	}

	private static void findPairOfRoses(int[] a, int n, int sum) {
		int i = 0;
		int j = n - 1;
		int mini = 0;
		int minj = 0;
		int diff = Integer.MAX_VALUE;
		while (i < j) {
			if (a[i] + a[j] == sum) {
				if (a[i] - a[j] < diff) {
					mini = i;
					minj = j;
				}
				i++;
				j--;
			} else if (a[i] + a[j] > sum) {
				j--;
			} else {
				i++;
			}
		}
		if (mini != minj)
			System.out.println("Deepak should buy roses whose prices are " + a[mini] + " and " + a[minj]+".");
	}
}
