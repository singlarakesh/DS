package GreedyAproach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Job {
	int id, profit, deadLine;

	Job(int id, int deadLine, int profit) {
		this.id = id;
		this.profit = profit;
		this.deadLine = deadLine;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", profit=" + profit + ", deadLine=" + deadLine + "]";
	}
}

public class JobSeqPlb {
	public static void main(String[] args) {
		ArrayList<Job> arr = new ArrayList<Job>();
		arr.add(new Job('a', 2, 100));
		arr.add(new Job('b', 1, 19));
		arr.add(new Job('c', 2, 27));
		arr.add(new Job('d', 1, 25));
		arr.add(new Job('e', 3, 15));
		Collections.sort(arr, (a, b) -> {
			return b.profit - a.profit;
		});
		System.out.println(arr);
//		Map<Integer, Integer> map = new HashMap<>();
//		for (Job j : arr) {
//			if (map.containsKey(j.deadLine)) {
//				int p = map.get(j.deadLine);
//				if (p < j.profit) {
//					map.put(j.deadLine, j.profit);
//				}
//			} else {
//				map.put(j.deadLine, j.profit);
//			}
//		}
//		int ans[]=new int[map.size()];
//		int j=0;
//		for(int i:map.keySet()) {
//			ans[j]=map.get(i);
//		}
		
		for (Job j : arr) {
			
		}
	}
}
