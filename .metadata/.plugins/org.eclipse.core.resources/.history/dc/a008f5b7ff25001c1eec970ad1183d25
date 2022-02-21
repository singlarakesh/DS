import java.util.Scanner;

public class AtoB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scr = new Scanner(System.in);
		String a = scr.next();
		String b = scr.next();
		int c = 1;
		String tempa=a;
		while (a.length() < b.length()) {
			a += tempa;
			c++;
		}
		int i = 0;
		int j = 0;
		while (j < b.length()) {
			int tempj=j;
			while (i < a.length() && j < b.length()) {
				if (a.charAt(i) == b.charAt(j)) {
					i++;
					j++;
				} else {
					i++;
				}
			}
			if(tempj==j) {
				c=-1;
				break;
			}
			if(j<b.length()) {
				a += tempa;
				c++;
			}
		}
		System.out.println(c);
	}

}
