package HacherBlocks;

import java.util.ArrayList;
import java.util.Scanner;

public class ACountAAA {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		String str = scr.nextLine();
//		code_for_string(str);
//      System.out.println(count(str,0));
//      System.out.println(countNotOverlap(str,0));
//      System.out.println(countTwins(str));
	}

//	private static ArrayList<String> code_for_string(String str) {
//		// TODO Auto-generated method stub
//		if (str.length()<=0) {
//			ArrayList<String> res = new ArrayList<String>();
//			return res;
//		}
//		ArrayList<String> res = new ArrayList<String>();
//		String code1 = str.substring(0, 1);
//		ArrayList<String> res1=code_for_string(str.substring(1));
//		String code2 = str.substring(0, 2);
//		ArrayList<String> res2=code_for_string(str.substring(2));
//		for (String val : code1) {
//			res.add(val);
//		}
//	}

	private static char findCode(String str) {
		return (char) (Integer.parseInt(str) + 96);
	}

	private static int countTwins(String str) {
		// TODO Auto-generated method stub
		if (str.length() < 3) {
			return 0;
		}
		if (str.charAt(0) == str.charAt(2)) {
			return countTwins(str.substring(1)) + 1;
		} else {
			return countTwins(str.substring(1));
		}
	}

	private static int countNotOverlap(String str, int i) {
		// TODO Auto-generated method stub
		if (str.length() < 3) {
			return 0;
		}
		String s = str.substring(0, 3);
		if (s.compareTo("aaa") == 0) {
			return countNotOverlap(str.substring(3), i) + 1;
		} else {
			return countNotOverlap(str.substring(1), i);
		}
	}

	private static int count(String str, int i) {
		// TODO Auto-generated method stub
		if (str.length() < 3) {
			return 0;
		}
		String s = str.substring(0, 3);
		if (s.compareTo("aaa") == 0) {
			return count(str.substring(1), i) + 1;
		} else {
			return count(str.substring(1), i);
		}
	}
}
