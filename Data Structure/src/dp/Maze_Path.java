package dp;

import java.util.Scanner;

public class Maze_Path {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int m = scr.nextInt();
		int n = scr.nextInt();
		int a[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = scr.nextInt();
			}
		}
		mazePath(a, 0, 0, m, n);
	}

	private static int mazePath(int[][] a, int sr, int sc, int er, int ec) {
		// TODO Auto-generated method stub
		if (sr == er && sc == ec) {
			return 1;
		}
		if (sr > er && sc > ec) {
			return 0;
		}
		int m=mazePath(a, sr+1, sc, er, ec);
		int n=mazePath(a, sr, sc+1, er, ec);
		return m+n;
	}
}
