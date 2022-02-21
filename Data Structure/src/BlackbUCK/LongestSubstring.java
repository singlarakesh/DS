package BlackbUCK;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
	public static void main(String[] args) {
		String str = "GEEKSFORGEEKS";
		int cmax = Integer.MIN_VALUE;
		int c = 0;
		Set<Character> s = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (s.add(ch)) {
				c++;
				cmax = Math.max(c, cmax);
			} else {
				c = 0;
				s = new HashSet<Character>();
			}
		}
		System.out.println(cmax);
	}
}
