package dp;

import java.util.Stack;

public class DecodeWays {
	static int count = 0;

	public static void main(String[] args) {
		String s = "28";
		numDecodings(s, "");
		System.out.println(count);
	}

	public static void numDecodings(String s, String ans) {
		if (s.length() == 0) {
			System.out.println(ans);
			count += 1;
			return;
		}
		if (s.charAt(0) == '0')
			return;
		String res = getCharForNumber(Integer.parseInt(s.substring(0, 1)));
		numDecodings(s.substring(1), ans + res);
		if (s.length() >= 2) {
			if (Integer.parseInt(s.substring(0, 2)) >= 28)
				return;
			String res1 = getCharForNumber(Integer.parseInt(s.substring(0, 2)));
			numDecodings(s.substring(2), ans + res1);
		}
	}

	private static String getCharForNumber(int i) {
		return i > 0 && i < 27 ? String.valueOf((char) (i + 64)) : null;
	}
}
