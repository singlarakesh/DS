
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class QItem {
	int row;
	int col;
	int dist;

	public QItem(int row, int col, int dist) {
		this.row = row;
		this.col = col;
		this.dist = dist;
	}
}

public class ArraysBasic {
	public static void main(String[] args) {
		int[][] ar = { {0,1,0,0,0},
	            {0,0,0,0,0},
	            {0,1,0,0,0},
	            {0,1,0,9,0},
	            {0,0,0,0,0},};
//		demolitionRobot(ar, 0, 0, ar.length-1, ar[0].length-1, "");
//		boolean visited[][]=new bsoolean[ar.length][ar[0].length];
//		System.out.println(demolitionRobot(ar, 0, 0, ar.length - 1, ar[0].length - 1, "",visited));
//		System.out.println(demolitionRobotDp(ar));
//		System.out.println(minDistance(ar));
		List<List<String>> list = new ArrayList<>();

		list.add(Arrays.asList("a", "b", "c"));
		list.add(Arrays.asList("dd"));
		list.add(Arrays.asList("eee", "fff"));
		String[][] array = new String[list.size()][];

		int l = 0;
		for (List<String> nestedList : list) {
		    array[l++] = nestedList.toArray(new String[nestedList.size()]);
		}
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[0].length;j++){
               System.out.println(array[i][j]);
            }
        }
	}
//    public static int[][] makeGrid(List<List<Integer>> area){
//        int grid[][]=new int[area.size()][area.get(0).size()];
//        for(int i=0;i<area.size();i++){
//            for(int j=0;j<area.get(0).size();j++){
//                grid[i][j]=area.get(i).get(j);
//            }
//        }
//        
//    }

	private static int minDistance(int[][] grid) {
		int dist = Integer.MAX_VALUE;
		QItem source = new QItem(0, 0, 0);

		// applying BFS on matrix cells starting from source
		Queue<QItem> queue = new LinkedList<QItem>();
		queue.add(new QItem(source.row, source.col, 0));

		boolean[][] visited = new boolean[grid.length][grid[0].length];
		visited[source.row][source.col] = true;

		while (queue.isEmpty() == false) {
			QItem p = queue.remove();

			// Destination found;
			if (grid[p.row][p.col] == 9) {
//				dist = Math.min(dist, p.dist);
				return p.dist;
			}

			// moving up
			if (isValid(p.row - 1, p.col, grid, visited)) {
				queue.add(new QItem(p.row - 1, p.col, p.dist + 1));
				visited[p.row - 1][p.col] = true;
			}

			// moving down
			if (isValid(p.row + 1, p.col, grid, visited)) {
				queue.add(new QItem(p.row + 1, p.col, p.dist + 1));
				visited[p.row + 1][p.col] = true;
			}

			// moving left
			if (isValid(p.row, p.col - 1, grid, visited)) {
				queue.add(new QItem(p.row, p.col - 1, p.dist + 1));
				visited[p.row][p.col - 1] = true;
			}

			// moving right
			if (isValid(p.row , p.col + 1, grid, visited)) {
				queue.add(new QItem(p.row, p.col + 1, p.dist + 1));
				visited[p.row][p.col + 1] = true;
			}
		}
//		System.out.println(dist);
		return -1;
	}

	// checking where it's valid or not
	private static boolean isValid(int x, int y, int[][] grid, boolean[][] visited) {
		if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] != 0 && visited[x][y] == false) {
			return true;
		}
		return false;
	}

	private static int demolitionRobotDp(int[][] ar) {
		// TODO Auto-generated method stub
		int dp[][] = new int[ar.length][ar[0].length];
		dp[ar.length - 1][ar[0].length - 1] = 0;
		for (int j = ar.length - 2; j >= 0; j--) {
			dp[j][ar.length - 1] = 1;
		}
		for (int j = ar.length - 2; j >= 0; j--) {
			dp[ar.length - 1][j] = 1;
		}
		for (int i = ar.length - 2; i >= 0; i--) {
			for (int j = ar[0].length - 2; j >= 0; j--) {
				dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
			}
		}
		return dp[0][0];
	}

	private static int demolitionRobot(int[][] ar, int sr, int sc, int er, int ec, String ans, boolean[][] visited) {
		// TODO Auto-generated method stub
		if (sr < 0 || sc < 0)
			return Integer.MAX_VALUE;
		if (sr > er || sc > ec)
			return Integer.MAX_VALUE;
		if (visited[sr][sc]) {
			return ar[sc][sr];
		}
		visited[sr][sc] = true;
		if (ar[sr][sc] == 0) {
			return Integer.MAX_VALUE;
		}
		if (ar[sr][sc] == 9) {
			System.out.println(ans);
			return 0;
		}
		int res1 = demolitionRobot(ar, sr + 1, sc, er, ec, ans + "V", visited);
		int res2 = demolitionRobot(ar, sr, sc + 1, er, ec, ans + "H", visited);
		int res3 = demolitionRobot(ar, sr - 1, sc, er, ec, ans + "-V", visited);
		int res4 = demolitionRobot(ar, sr, sc - 1, er, ec, ans + "-H", visited);
		int res = Math.min(Math.min(res1, res2), Math.min(res3, res4));
		if (res != Integer.MAX_VALUE) {
			res += 1;
		}
		ar[sr][sc] = res;
		return res;
	}
	// memoization
//	private static int demolitionRobot(int[][] ar, int sr, int sc, int er, int ec, int dp[][]) {
//		// TODO Auto-generated method stub
//		if (sr == er && sc == ec) {
//			System.out.println(ans);
//			return 1;
//		}
//		if (sr > er || sc > ec)
//			return 0;
////		if (ar[sr][sc] == 0) {
////			return 0;
////		}
//		if(dp[][]) {
//			
//		}
//		int res1=demolitionRobot(ar, sr + 1, sc, er, ec, ans + "V");
//		int res2=demolitionRobot(ar, sr, sc + 1, er, ec, ans + "H");
//		dp[sr][sc]=res1+res2;
//		return res1+res2;
//	}
}
