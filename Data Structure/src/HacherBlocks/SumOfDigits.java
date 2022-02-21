package HacherBlocks;

import java.util.Scanner;

public class SumOfDigits {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		String s = scr.next();
		int odd=0;
		int even=0;
		for (int i = 0; i < s.length(); i++) {
			char c=s.charAt(i);
			if (i % 2 == 0) {
				even+=Integer.parseInt(String.valueOf(c));
			} else {
				odd+=Integer.parseInt(String.valueOf(c));
			}
		}
		System.out.println(odd);
		System.out.println(even);
	}
}
