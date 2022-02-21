package HacherBlocks;

import java.util.HashMap;
import java.util.Scanner;

public class ASortLinearTime {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scr.nextInt();
		}
		sortArray(a);
	}

	private static void sortArray(int[] a) {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(a[i])) {
				int val = map.get(a[i]);
				map.put(a[i], val + 1);
			} else {
				map.put(a[i], 1);
			}
		}
		for (int item : map.keySet()) {
			int c = map.get(item);
			while (c != 0) {
				System.out.println(item);
				c--;
			}
		}
	}

}
