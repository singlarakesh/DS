package com.craftAssignment.Intuit;

import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
//		subArraySumEqual0();
		subArraySumEqualK();
	}

	private static void subArraySumEqualK() {
//		10, 2, -2, -20, 10
//		-10
		int arr[] = { 9, 4, 20, 3, 10, 5 };
		int k = 33;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);
		int sum = 0;
		int ans = 0;
		for (int i : arr) {
			sum += i;
			if (map.containsKey(sum - k)) {
				ans += map.get(sum - k);
				map.put(sum-k, map.get(sum - k) + 1);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		System.out.println(ans);
	}

	private static void subArraySumEqual0() {
		int ar[] = { 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
//		-1 -3 4
//		-2 2
//		-1 -3 4 -2 2
//		2 4 6 -12
//		 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		int ans = 0;
		map.put(0, 1);
		for (int i : ar) {
			sum += i;
			if (map.containsKey(sum)) {
				int c = map.get(sum);
				ans += c;
				map.put(sum, c + 1);
			} else {
				map.put(sum, 1);
			}
		}
		System.out.println(ans);
	}
}
