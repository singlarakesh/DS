package HacherBlocks;

import java.util.Scanner;
//0 1 10 100 1000 101 102 103 104 105--109 11 110 112 --119 12 2---9
public class ALexicograpich {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scr = new Scanner(System.in);

		int n = scr.nextInt();
		lexico(0, n);
	}

	private static void lexico(int current, int end) {
		// TODO Auto-generated method stub
		if (current > end) {
			return;
		}
		System.out.println(current);
		if (current == 0) {
			for(int i=1;i<9;i++) {
				lexico(current*10+i, end);
			}
		} else {
			for(int i=0;i<9;i++) {
				lexico(current*10+i, end);
			}
		}
	}

}
