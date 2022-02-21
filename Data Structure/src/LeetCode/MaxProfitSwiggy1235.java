package LeetCode;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class MaxProfitSwiggy1235 {
	public static void main(String[] args) {
		int startTime[] = { 1, 2, 3, 3 };
		int endTime[] = { 3, 4, 5, 6 };
		int profit[] = { 50, 10, 40, 70 };
		System.out.println(jobScheduling(startTime, endTime, profit, 0, 0, 0));
		;
	}

	public static long maximiseRevenue(List<Long> pickup, List<Long> drop, List<Integer> tip) {
		long[] example2 = pickup.stream().mapToLong(Long::longValue).toArray();
		int[] larr = Arrays.stream(example2).mapToInt((i) -> Math.toIntExact(i)).toArray()
		int n = pickup.size();
		int[][] jobs = new int[n][3];
		for (int i = 0; i < n; i++) {
			jobs[i] = new int[] { Math.toIntExact(pickup.get(i)), Math.toIntExact(drop.get(i)),
					Math.toIntExact(tip.get(i)) };
		}
		Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
		TreeMap<Integer, Integer> dp = new TreeMap<>();
		dp.put(0, 0);
		for (int[] job : jobs) {
			int val = job[2] + dp.floorEntry(job[0]).getValue();
			if (val > dp.lastEntry().getValue()) {
				dp.put(job[1], val);
			}

		}
		return dp.lastEntry().getValue();
	}

}

	private static int jobScheduling(int[] startTime, int[] endTime, int[] profit, int start, int i, int ans) {
		// TODO Auto-generated method stub
		if (i >= startTime.length) {
//			System.out.println(ans);
			return 0;
		}
		if (startTime[i] >= start) {
			return Math.max(jobScheduling(startTime, endTime, profit, endTime[i], i + 1, ans + profit[i]) + profit[i],
					jobScheduling(startTime, endTime, profit, start, i + 1, ans));
		} else {
			return jobScheduling(startTime, endTime, profit, start, i + 1, ans);
		}

	}
}
