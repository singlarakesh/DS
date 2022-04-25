package slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {
	public static void main(String[] args) {
		String s = "d";
		
		if(s=="")
			System.out.println("0");;
		Set<Character> set = new HashSet<>();
		int i = 0;
		int j = 0;
		int len = Integer.MIN_VALUE;
		while (j < s.length()) {
			Character ch = s.charAt(j);
			if (set.add(ch)) {
				int size = j - i + 1;
				len = len < size ? size : len;
				j++;
			} else {
				while (!set.add(ch)) {
					set.remove(s.charAt(i));
					i++;
				}
				set.add(ch);
				j++;
			}
		}
		System.out.println(len);
	}
}
