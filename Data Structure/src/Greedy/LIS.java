package Greedy;

import java.util.HashMap;

public class LIS {
	public static void main(String[] args) {
//		HashMap<String, Integer> map = new HashMap<>();
//		map.put("Mon", 1);
//		map.put("Tue", 2);
//		map.put("Wed", 3);
//		map.put("Thu", 4);
//		map.put("Fri", 5);
//		map.put("Sat", 6);
//		map.put("Sun", 7);
//		String s = "Sat";
//		int k = 21;
////		k = map.get(s) + k;
//		int re = k % 7;
//		int index=(map.get(s)+re)%7;
//		for(String week:map.keySet()) {
//			if(map.get(week)==index) {
//				System.out.println(week);
//			}
//		}
		String s = "abccbd";
		int c[] = { 0, 1, 2, 3, 4, 5 };
		int i=0;
		int j=1;
		int min=0;
		while (j<s.length()) {
			if(j<s.length() && s.charAt(i)==s.charAt(j)) {
				j++;
			}
			int k=j-i;
		    int localMin
			while(k>1) {
				min+=Math.m
			}
			i=j;
			j++;
		}
	}
}
