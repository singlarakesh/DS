package HacherBlocks;

import java.util.Scanner;

public class ARecursion_Nth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		System.out.println(rec(n));
	}

	private static int rec(int n) {
		// TODO Auto-generated method stub
		if (n == 1)
			return n;
		return n+rec(n-1);
	}

}
