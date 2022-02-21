package String;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class UncommonWords {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		String s1 = scr.nextLine();
		String s2 = scr.nextLine();
		String s = s1.concat(" " + s2);
		String[] a = s.split(" ");
		List<String> ans = new LinkedList<>();
		HashMap<String, Integer> map = new HashMap<>();
		for (String sans : a) {
			if (map.containsKey(sans)) {
				int count=map.get(sans)+1;
				map.put("sans", count);
			} else {
				map.put("sans", 1);
			}
		}
		for(String sans:map.keySet()) {
			if(map.get(sans)==1) {
			  ans.add(sans);	
			}
		}
	}
}
