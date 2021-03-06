package Graph;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
	int x;
	int y;

	@Override
	public String toString() {
		return "Pair [x=" + x + ", y=" + y + "]";
	}

	public Pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class IslandInGraph {
	public static void main(String[] args) {
		int mat[][] = { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1 } };

		System.out.print(countIslands(mat));
	}

	private static int countIslands(int[][] mat) {
		// TODO Auto-generated method stub
		int count = 0;
		boolean vist[][] = new boolean[mat.length][mat[0].length];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (!vist[i][j] && mat[i][j] == 1) {
					traverseItsIsland(mat, vist, i, j);
					count++;
				}
			}
		}
		return count;
	}

	private static void traverseItsIsland(int[][] mat, boolean[][] vist, int r, int c) {
		// TODO Auto-generated method stub

		int row[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int col[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(r, c));
		vist[r][c] = true;
		while (!q.isEmpty()) {
			System.out.println(q);
			int x = q.peek().x;
			int y = q.peek().y;
			q.remove();
			for (int i = 0; i < 8; i++) {
				if (isSafe(x + row[i], y + col[i], mat, vist)) {
					q.add(new Pair(x + row[i], y + col[i]));
					vist[x + row[i]][y + col[i]] = true;
				}
			}
		}

	}

	@Override
	public String toString() {
		return "IslandInGraph []";
	}

	private static boolean isSafe(int i, int j, int[][] mat, boolean[][] vist) {
		// TODO Auto-generated method stub
		if (i >= 0 && j >= 0 && mat.length > i && mat[0].length > j && !vist[i][j] && mat[i][j] == 1) {
			return true;
		}
		return false;
	}
}
