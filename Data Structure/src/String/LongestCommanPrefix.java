package String;

import java.util.Scanner;

public class LongestCommanPrefix {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		String str[] = new String[n];
		for (int i = 0; i < n; i++) {
			str[i] = scr.next();
//			System.out.println("hello"+i);
		}
		System.out.println(findPrefix(str));
		findPrefix(str);
	}

	private static String findPrefix(String[] str) {
		// TODO Auto-generated method stub
		String prefix = "";
		if (str.length == 1) {
			return str[0];
		} else {
			String s1 = str[0];
			String s2 = str[1];

			int i = 0, j = 0;
			while (i < s1.length() && j < s2.length()) {
				if (s1.charAt(i) == s2.charAt(j)) {
					prefix += s1.charAt(i);
				} else {
					break;
				}
				i++;j++;
			}
		}
		return prefix;
	}
}
