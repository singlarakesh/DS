package com.example.demo;

import java.util.*;

public class Test extends Object {
	public static void main(String[] args) {
//		String text = "forxxorfxdofr";
//		String word = "for";
//		System.out.print(countAnagrams(text, word));
//		Set<INTEGER>
//		list.stream().filter(Collector.frequency(list,i>2)).collect(Collector.toList());
//		Map<Integer,Integer> map=new HashMap<>();
//		int  ar[]= {10,20,20,30,30,40};
//		Set<Integer> s = new HashSet<>();
//		List<Integer> as=Arrays.asList(10,20,20,30,30,40);
//		as.stream().map(x->s.add(x)).forEach(System.out::println);
//		System.out.println(Objects.hashCode("hello"));

//		Object obj1 = new Object();
//		Object obj2 = new Object();
//		System.out.println(obj1.equals(obj2));
//		HashMap<Object, Integer> map=new HashMap<Object, Integer>();
//		map.put(obj2, 1);
//		map.put(obj1, 2);
//		System.out.println(map.get(obj2));
	}

	public static int returnValue() {
		final int a = 10;
		return a;
	}

	private static int countAnagrams(String text, String word) {
		// TODO Auto-generated method stub
		int cmax = 0;
		int[] textA = new int[26];
		int[] wordA = new int[26];
		int i = 0;
		for (; i < word.length(); i++) {
			textA[text.charAt(i) - 'a']++;
			wordA[word.charAt(i) - 'a']++;
		}
		if (Arrays.equals(textA, wordA))
			cmax += 1;
		for (; i < text.length(); i++) {
			textA[text.charAt(i) - 'a']++;
			textA[text.charAt(i - word.length()) - 'a']--;

			if (Arrays.equals(textA, wordA))
				cmax += 1;
		}
		return cmax;
	}
}
