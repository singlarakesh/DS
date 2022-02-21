import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
//https://leetcode.com/discuss/interview-question/1031663/Amazon-OA
public class Ques3 {
	public static void main(String[] args) {
		int pants[] = { 3, 5, 7 }, shirts[] = { 4, 7, 8 }, skirts[] = { 5, 8 }, shoes[] = { 3 };
		List<Integer> jeans = Arrays.stream(pants).boxed().collect(Collectors.toList());
		List<Integer> top = Arrays.stream(shirts).boxed().collect(Collectors.toList());
		List<Integer> skirt = Arrays.stream(skirts).boxed().collect(Collectors.toList());
		List<Integer> shoe = Arrays.stream(shoes).boxed().collect(Collectors.toList());
		System.out.println(numOfOtions(jeans, top, skirt, shoe, 25));
	}

	public static int numOfOtions(List<Integer> jeans, List<Integer> top, List<Integer> skirt, List<Integer> shoes,
			int budget) {

		int count = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		if (budget == 0) {
			return count;
		}
		for (int i1 : jeans) {
			for (int i2 : top) {
				int sum = i1 + i2;
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			}
		}

		for (int i3 : skirt) {
			for (int i4 : shoes) {
				int sum = budget - (i3 + i4);
				for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
					if (entry.getKey() <= sum) {
						count += entry.getValue();
					}
				}
			}
		}
		return count;
	}
}
