package dp;

public class WordSearch79 {
	public static void main(String[] args) {
		char board[][] = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "DBCCED";
		boolean visited[][] = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (word.charAt(0) == board[i][j] && exist(board, word, i, j, 0, visited)) {
					return true;
				}
			}
		}

//		System.out.println(exist(board, word, 0, 0, 0));
	}

	public static boolean exist(char[][] board, String word, int i, int j, int k, boolean[][] visited) {
		if (k >= word.length())
			return true;
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
			return false;
		}
		if (board[i][j] != word.charAt(k)) {
			return false;
		}
		visited[i][j] = true;
		boolean exist = exist(board, word, i + 1, j, k + 1, visited) || exist(board, word, i, j + 1, k + 1, visited)
				|| exist(board, word, i - 1, j, k + 1, visited) || exist(board, word, i, j - 1, k + 1, visited);
		visited[i][j] = false;
		return exist;
	}

	public static boolean isValid(char[][] board, int i, int j) {

		return true;
	}
}
