package slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountOfAnagrm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aa";
		String p = "bb";
		HashMap<Character, Integer> map = new HashMap<>();
		int i = 0;
		while (i < p.length()) {
			char ch = str.charAt(i);
			if (map.containsKey(ch)) {
				int v = map.get(ch);
				map.put(ch, v + 1);
			} else {
				map.put(ch, 1);
			}
			i++;
		}
		int count = map.size();
		findAnagram(str, map, count, p.length());
	}

	private static void findAnagram(String str, HashMap<Character, Integer> map, int count, int k) {
		int i = 0;
		int j = 0;
		int sum = 0;
		List<Integer> list=new ArrayList<>();
		while (j < str.length()) {
			char ch = str.charAt(j);
			if (map.containsKey(ch)) {
				int v = map.get(ch);
				map.put(ch, v - 1);
				if (map.get(ch) == 0) {
					count--;
				}
			}
			if (j - i + 1 == k) {
				if (count == 0) {
					list.add(i);
					sum += 1;
				}
				char chi = str.charAt(i);
				if (map.containsKey(chi)) {
					if (map.get(chi) == 0) {
						count++;
					}
					int v = map.get(chi);
					map.put(chi, v + 1);
				}
				i++;
				j++;
			} else {
				j++;
			}
		}
		System.out.println(list);
	}
}
