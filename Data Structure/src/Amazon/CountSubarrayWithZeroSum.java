package Amazon;

import java.util.HashMap;
import java.util.Map;

public class CountSubarrayWithZeroSum {
	public static void main(String[] args) {
		int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
		System.out.println(findSubArrays(arr));
	}

	private static int findSubArrays(int[] arr) {
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);
		int cmax=0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (map.containsKey(sum)) {
				cmax+=map.get(sum);
				map.put(sum, map.get(sum) + 1);
			} else {
				map.put(sum, 1);
			}
		}
		return cmax;
	}
}
