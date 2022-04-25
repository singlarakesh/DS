package dp;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
	int x;
	int y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class set_matrix_zero_73 {
	public static void main(String[] args) {
		int matrix[][] = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		boolean visited[][] = new boolean[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (!visited[i][j] && matrix[i][j] == 0) {
					setZeroes(matrix, i, j, visited);
				}
			}
		}
	}

	public static void setZeroes(int[][] matrix, int i, int j, boolean[][] visited) {
		visited[i][j] = true;
//		Queue<Pair> q = new LinkedList<>();
//		Pair p = new Pair(i, j);
//		q.add(p);
		setZeroes(matrix, i+1, j, visited);
	}
}
