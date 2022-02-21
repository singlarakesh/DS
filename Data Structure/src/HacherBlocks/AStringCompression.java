package HacherBlocks;

import java.util.HashMap;
import java.util.Scanner;

public class AStringCompression {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		String str = scr.next();
		int j=-1;
		String ans = "";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				if(j!=-1) {
				char c = str.charAt(j);
				int count = map.get(c);
				if (count != 1)
					ans = ans + c + Integer.toString(count);
				else
					ans += c;
				map.remove(c);
				}
				j=i;
				
				map.put(ch, 1);
			}
		}
		if(j!=-1) {
			char c = str.charAt(j);
			int count = map.get(c);
			if (count != 1)
				ans = ans + c + Integer.toString(count);
			else
				ans += c;}
//		String ans = "";
//		for (int i = 0; i < str.length();) {
//			char ch = str.charAt(i);
//			int c = map.get(ch);
//			if (c != 1)
//				ans = ans + ch + Integer.toString(c);
//			else
//				ans += ch;
//			i += c;
//		}
		System.out.println(ans);
	}
}
