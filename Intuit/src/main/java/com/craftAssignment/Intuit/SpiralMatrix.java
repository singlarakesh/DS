package com.craftAssignment.Intuit;

public class SpiralMatrix {
	public static void main(String[] args) {
		int n = 3;
		generateMatrix(n);
	}

	public static int[][] generateMatrix(int n) {
		int m[][] = new int[n][n];
		int sr = 0, sc = 0, er = n, ec = n;
		int c = 1;
		while (sr < er && sc < ec) {
			for (int i = sr; i < er; i++) {
				m[sr][i] = c;
				c++;
			}
			sr++;
			for (int i = sr; i < er; i++) {
				m[i][ec] = c;
				c++;
			}
			ec--;
			for (int i = ec; i >= sc; i--) {
				m[er][i] = c;
				c++;
			}
			er--;
			for (int i = er; i >= sc; i--) {
				m[i][sc] = c;
				c++;
			}
			sc++;
		}
		return m;
	}
}
