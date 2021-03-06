package Graph;

import java.util.LinkedList;
import java.util.Queue;

class Point {
	int x;
	int y;

	Point() {
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class FloodFill {

	public static void main(String[] args) {
		int images[][] = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		int sr = 1, sc = 1;
		floodFill(images, sr, sc, 2);
	}

	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int dp[][] = new int[image.length][image[0].length];
		boolean[][] visited = new boolean[image.length][image[0].length];
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++) {
				if (!visited[i][j]) {
					fillImage(image, newColor, visited, i, j);
				}
			}
		}
		return dp;
	}

	private static void fillImage(int[][] image, int newColor, boolean[][] visited, int i, int j) {
		// TODO Auto-generated method stub
		int l[] = { -1, 0, 0, 1 };
		int r[] = { 0, -1, 1, 0 };
		Point point = new Point(i, j);
		Queue<Point> q = new LinkedList<>();
		q.add(point);
		while (!q.isEmpty()) {
			Point p = q.poll();
			int x = p.x;
			int y = p.y;
			image[x][y]=newColor;
			for (int m = 0; m < 4; m++) {
				if (isValid(image, l[m] + x, l[m] + y, newColor, visited)) {
					q.add(new Point(l[m] + x, l[m] + y));
					visited[l[m] + x][l[m] + y] = true;
				}
			}
		}

	}

	public static boolean isValid(int[][] image, int i, int j, int val, boolean visited[][]) {
//		if (i >= 0 && j >= 0 && i < image.length && j < image[0].length && image[i][j] == val && !visited[i][j]) {
//			return true;
//		}
//		return false;
	}
}
