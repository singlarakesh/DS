package Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class CheapestFair {
	public static void main(String[] args) {
		int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };
		findCheapestPrice(3, flights, 0, 2, 1);
		System.out.println(findCheapestPrice(3, flights, 0, 2, 0));
	}

	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		HashMap<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
		for (int[] ft : flights) {
			if (!map.containsKey(ft[0])) {
				map.put(ft[0], new HashMap<Integer, Integer>());
			}
			map.get(ft[0]).put(ft[1], ft[2]);
		}
		Queue<int[]> q = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
		q.add(new int[] { 0, src, k + 1 });
		while (!q.isEmpty()) {
			int rp[] = q.remove();
			int cost = rp[0];
			int city = rp[1];
			int stop = rp[2];
			if (city == dst) {
				return cost;
			}
			if (stop > 0) {
				Map<Integer, Integer> m = map.getOrDefault(city, new HashMap<>());
				for (int l : m.keySet()) {
					q.add(new int[] { cost + m.get(l), l, stop-1 });
				}
			}
		}
		return -1;
	}
}
