package Graph;

import java.util.Arrays;

public class LargestPlus {
	public static void main(String[] args) {

	}

	public int orderOfLargestPlusSign(int N, int[][] mines) {
		int grid[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(grid[i], N);
		}

		for (int[] m : mines) {
			grid[m[0]][m[1]] = 0;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0, k = N - 1, l = 0, r = 0, u = 0, d = 0; j < N; j++, k--) {
			}
		}
	}
}
