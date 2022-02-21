package Graph;

import java.util.ArrayList;
import java.util.List;

public class RateInMaze {

	public static void main(String[] args) {
		int n = 4;
		int m[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };
		List<String> lans = new ArrayList<String>();
		printPath(m, 0, 0, n - 1, n - 1, "",lans);
		
		System.out.println(lans);
	}

	private static void printPath(int[][] m, int sr, int sc, int er, int ec, String ans, List<String> lans) {
		// TODO Auto-generated method stub
		if (sr == er && sc == ec) {
			lans.add(ans);
			return;
		}
		if (sr > er || sc > ec) {
			return;
		}
		if (m[sr][sc] == 0) {
			return;
		}
		printPath(m, sr + 1, sc, er, ec, ans + "D", lans);
		printPath(m, sr, sc + 1, er, ec, ans + "R", lans);
	}
}
