package String;

import java.util.Scanner;

public class Permutation {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		String str = scr.next();
		calPermutation(str, "");
	}

	private static void calPermutation(String str, String ans) {
		if (str == "") {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			String rest=str.substring(0,i)+str.substring(i+1);
			calPermutation(rest, ans+ch);
		}
	}
}
