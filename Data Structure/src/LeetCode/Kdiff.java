package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Kdiff {
	public static void main(String[] args) {
		int nums[] = { 3, 1, 4, 1, 5 };
		int k=1;
		Set<Integer> items = new HashSet(Arrays.asList(nums));
		System.out.println(items.contains(1));
//		for(int l:items) {
//			System.out.println(l);
//		}
	}
}
