package Graph;

public class NumberOfClosedIslands {
	static int directions[][] = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

	public static void main(String[] args) {
		int grid[][] = { { 0, 0, 0, 0, 0 }, { 0, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 } };
		int res = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					if (dfs(grid, i, j)) {
						res++;
					}
				}
			}
		}
		System.out.println(res);
	}

	private static boolean dfs(int[][] grid, int i, int j) {
		// TODO Auto-generated method stub
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
			return false;
		}
		if((i==0 || j==0 ) && grid[i][j]==0) {return false;}
		if (grid[i][j] == 1)
			return true;
//		g
	      grid[i][j] = 1;
		boolean res = true;
		for (int k = 0; k < directions.length; k++) {
			res = res && dfs(grid, i + directions[k][0], j + directions[k][1]);
		}
		return res;
	}
}
