package Graph;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
	int x;
	int y;

	public Pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class RottenOranges {
	public static void main(String[] args) {
		int[][] grid = { { 0, 1, 2 }, { 0, 1, 2 }, { 2, 1, 1 } };
		orangesRotting(grid);
	}

	public static int orangesRotting(int[][] grid) {
		int visited[][] = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 2) {
					makeYourNghrRotten(i, j, grid, visited);
				}
			}
		}
		return 0;
	}

	private static void makeYourNghrRotten(int i, int j, int[][] grid, int[][] visited) {
		// TODO Auto-generated method stub
		int r[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int c[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
		Queue<Pair> q = new LinkedList<Pair>();
		Pair p = new Pair(i, j);
		q.add(p);
		while (!q.isEmpty()) {
			Pair rm = q.poll();
			int px = rm.x;
			int py = rm.y;
			for (int k = 0; k < 8; k++) {
				if (isValid(px + r[k], py + c[k], grid, visited)) {
					q.add(new Pair(px + r[k], py + c[k]));
					grid[i][j]=2;
				}
			}
		}
	}

	private static boolean isValid(int i, int j, int[][] grid, int[][] visited) {
		// TODO Auto-generated method stub
		if (i >= grid.length && j >= grid[0].length && i < 0 && j < 0 && grid[i][j] == 1)
			return true;
		return false;
	}
}
