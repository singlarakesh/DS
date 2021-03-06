package Graph;

import java.util.Arrays;

public class DJSet {
	public int[] upper;

	public DJSet(int n) {
		upper = new int[n];
		Arrays.fill(upper, -1);
	}

	public int root(int x) {
		return upper[x] < 0 ? x : (upper[x] = root(upper[x]));
	}

	public boolean union(int x, int y) {
		x = root(x);
		y = root(y);
		if (x != y) {
			if (upper[y] < upper[x]) {
				int d = x;
				x = y;
				y = d;
			}
			upper[x] += upper[y];
			upper[y] = x;
		}
		return x == y;
	}

	public int count() {
		int ct = 0;
		for (int u : upper)
			if (u < 0)
				ct++;
		return ct;
	}

	public boolean equiv(int x, int y) {
		return root(x) == root(y);
	}

	public static void main(String[] args) {
		String str = "abccc";
		char[][] m = { { 'b', 'c' }, { 'a', 'b' } };
		System.out.println(fn(str, m));
	}

	public static String fn(String string, char[][] m) {
		DJSet ds = new DJSet(26);
		for (int i = 0; i < m.length; i++) {
			ds.union(m[i][0] - 'a', m[i][1] - 'a');
		}
		char[] s = string.toCharArray();
		outer: for (char c = 'a'; c <= 'z'; c++) {
			for (int i = 0; i < s.length; i++) {
				if (!ds.equiv(c - 'a', s[i] - 'a'))
					continue outer;
			}
			return "YES";
		}
		return "NO";
	}
}
