package com.craftAssignment.Intuit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class GoodPlay {
	public static void main(String[] args) {
//		String s = "";
//		int minRem = 0;
//		minRem = findMinRemoval(s);
		int ar[] = { 4, 3, 2, 1 };
		System.out.println(peakSortedRotatedArray(ar));
	}

	public static int peakSortedRotatedArray(int a[]) {
		int lb = 0;
		int ub = a.length - 1;
		while (lb < ub) {
			int mid = (ub + lb) / 2;
			if (a[mid] < a[mid + 1] && a[mid] < a[mid - 1]) {
				return mid;
			} else if (a[mid] < a[ub]) {
				ub = mid;
			} else {
				lb = mid;
			}
		}
		return 0;
	}

	private static int findMinRemoval(String s) {
		// TODO Auto-generated method stub
		HashMap<Character, Integer> map = getMapOfCountOfChar(s);
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		int minCount = 0;
		for (Map.Entry<Character, Integer> it : map.entrySet()) {
			pq.add(it.getValue());
		}
		while (!pq.isEmpty()) {
			int element = pq.poll();
			if (pq.isEmpty()) {
				return minCount;
			}
			if (element == pq.peek()) {
				if (element > 1)
					pq.add(element - 1);
				minCount++;
			}
		}
		return minCount;
	}

	private static HashMap<Character, Integer> getMapOfCountOfChar(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		return map;
	}

}
