package HacherBlocks;

import java.util.Scanner;

public class MaximumSumSubarray {

	static int max_so_far = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		int n = scr.nextInt();
		int m = scr.nextInt();
		int g[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				g[i][j] = scr.nextInt();
			}
		}
		matrix_sum(g);
		max_so_far = Integer.MIN_VALUE;

	}

	private static void matrix_sum(int[][] g) {
		// TODO Auto-generated method stub
		int maxV=Integer.MIN_VALUE;
		for (int i = 0; i < g[0].length; i++) {
			int a[] = new int[g.length];
			for (int j = i; j < g[0].length; j++) {
				for (int k = 0; k < a.length; k++) {
					a[k] += g[k][j];
				}
				int max = kadeneAlgo(a);
				if (max > maxV ) {
					maxV = max;
				}
			}
		}
		System.out.println(maxV);
	}

	public static int kadeneAlgo(int g[]) {
		int curmax = 0;
		for (int i = 0; i < g.length; i++) {
			curmax += g[i];
			if (curmax > max_so_far) {
				max_so_far = curmax;
			}
			if (curmax < 0) {
				curmax = 0;
			}
		}
		return max_so_far;
	}
}
