package String;

import java.util.Scanner;

public class ReplaceWord {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		String dictionary[] = new String[n];
		for (int i = 0; i < n; i++) {
			dictionary[i] = scr.next();
		}
		String s = scr.nextLine();
		String sent[] = s.split(" ");
		for (int i = 0; i < n; i++) {
			int lt = dictionary[i].length();
			for (int j = 0; j < sent.length; j++) {
				String word = sent[j];
				if(word.length()>=lt) {
					if(word.substring(0,lt).compareTo(dictionary[i])==0) {
						sent[j]=dictionary[i];
					}
				}
			}
		}
		sent.toString().trim();
	}
}
