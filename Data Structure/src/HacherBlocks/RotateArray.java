package HacherBlocks;

import java.util.Scanner;

public class RotateArray {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scr.nextInt();
		}
		int k = scr.nextInt();
		k = k % n;
		int b[] = new int[n];
		for (int i=0;i<a.length;i++) {
			int j = (i + k) % n;
			b[j] = a[i];
		}
		for (int i=0;i<a.length;i++) {
			System.out.print(b[i]);
		}
	}
}
