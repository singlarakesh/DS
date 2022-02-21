package HacherBlocks;

import java.util.Scanner;

public class ARainWaterTrapping {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int tc = scr.nextInt();
		for (int i = 0; i < tc; i++) {
			int n = scr.nextInt();
			int a[] = new int[n];
			for (int j = 0; j < n; j++) {
				a[j] = scr.nextInt();
			}
			rainWaterTrap(a);
		}
	}

	private static void rainWaterTrap(int[] a) {
		// TODO Auto-generated method stub
		int i = 0;
		int j = a.length - 1;
		int max = Integer.MIN_VALUE;
		int sum = 0;
		while (i < j) {
			if (a[i] < a[j]) {
				if (max < a[i]) {
					max = a[i];
					i++;
				} else {
					sum += (max - a[i]);
					i++;
				}
			} else {
				if (max < a[j]) {
					max = a[j];
					j--;
				} else {
					sum += (max - a[j]);
					j--;
				}
			}
		}
		System.out.println(sum);
	}
}
