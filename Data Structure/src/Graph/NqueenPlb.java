package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class NqueenPlb {
	public static void main(String[] args) {
//		Scanner scr = new Scanner(System.in);
//		int n = scr.nextInt();
//		int board[][] = new int[n][n];
		Set<Integer> sets=new HashSet<>();
	    Map<Integer,Integer> map=new HashMap<Integer,Integer>();
	    map.put(10, 12);
	    System.out.println(map.put(10, 13));
	    System.out.println(map.put(10, 14));
//		nQueenPlb(board, 0, n);
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board.length; j++) {
//				System.out.print(board[i][j]);
//			}
//			System.out.println();
//		}
	}

	private static boolean nQueenPlb(int[][] board, int row, int n) {
		// TODO Auto-generated method stub
		if (row >= board.length)
			return true;
		for (int col = 0; col < n; col++) {
			if (isSafe(board, row, col)) {
				board[row][col] = 1;
				if (nQueenPlb(board, row + 1, n)) {
					return true;
				}
				board[row][col] = 0;
			}
		}
		return false;

	}

	private static boolean isSafe(int[][] board, int row, int col) {
		// TODO Auto-generated method stub
		for (int i = 0; i < row; i++) {
			if (board[i][col] == 1) {
				return false;
			}
		}
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}
		for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
			if (board[i][j] == 1) {
				return false;
			}
		}
		return true;
	}
}
