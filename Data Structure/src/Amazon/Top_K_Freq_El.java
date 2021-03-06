package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Element implements Comparator<Element> {
	int ele;
	int count;

	public Element() {
	}

	public Element(int ele, int count) {
		this.ele = ele;
		this.count = count;
	}

	@Override
	public int compare(Element o1, Element o2) {
		// TODO Auto-generated method stub
		return o2.count - o1.count;
	}
}

public class Top_K_Freq_El {
	public static void main(String[] args) {
		int nums[] = { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		Map<Integer, Integer> map = new HashMap<>();
//		for (int num : nums) {
//			if (map.containsKey(num)) {
//				map.put(num, map.get(num) + 1);
//			} else {
//				map.put(num, 1);
//			}
//		}
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0)+1);
		}
//		Queue<Element> q = new PriorityQueue<Element>(new Element());
		Queue<Integer> q = new PriorityQueue<Integer>((a,b)->map.get(b)-map.get(a));
		for (int i : map.keySet()) {
//			Element e = new Element(i, map.get(i));
			q.add(i);
		}
		int i = 0;
		int a[] = new int[k];
		while (k >= 1) {
			a[i] = q.poll();
			i++;
			k--;
		}
		for (int num : a) {
			System.out.println(num);
		}
//		List<int[]> num=Arrays.asList(nums);
//		System.out.println(num);
	}
}
