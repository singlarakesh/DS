package String;

import java.util.Scanner;

public class DecodedStringatIndex {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		String s = scr.next();
		int k = scr.nextInt();
		StringBuffer sb=new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			boolean b = Character.isDigit(s.charAt(i));
			if (b) {
				int d=(int)(s.charAt(i)-'0');
				System.out.println(d);
				int l=1;
				String str=sb.toString();
				while(l++ < d) {
					sb.append(str);
				}
			} else {
				sb.append(s.charAt(i));
			}
		}
		System.out.println(sb.toString().charAt(k-1));
	}
}
