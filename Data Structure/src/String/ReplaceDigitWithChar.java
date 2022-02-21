package String;

import java.util.Scanner;

public class ReplaceDigitWithChar {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		String str = scr.next();
//		leet code solution
//		char[] charArray = s.toCharArray();
//		for(int i = 1; i<charArray.length; i = i + 2) {
//		  charArray[i] = (char) (charArray[i - 1] + charArray[i] - '0');
//		}
//		return String.valueOf(charArray);
//		System.out.println(replaceAllDigitWithChar(str, ""));
//		replaceAllDigitWithChar(str, "");
	}

	private static String replaceAllDigitWithChar(String str, String ans) {
		// TODO Auto-generated method stub
		if (str.length() == 0)
			return ans;
		char ch = str.charAt(0);
		if (ans.length() % 2 != 0) {
			ch = (char) (ans.charAt(ans.length() - 1) + ch - '0');
		}
		return replaceAllDigitWithChar(str.substring(1), ans + ch);
	}
}
