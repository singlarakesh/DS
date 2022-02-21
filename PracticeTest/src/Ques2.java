import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class PairString {
	String first;
	String second;

	public PairString(String first, String second) {
		this.first = first;
		this.second = second;
	}
}

public class Ques2 {
	public static void main(String[] args) {
		List<PairString> data = new ArrayList<PairString>();
		PairString p1 = new PairString("Item1", "Item2");
		PairString p4 = new PairString("Item2", "Item8");
		PairString p2 = new PairString("Item3", "Item4");
		PairString p3 = new PairString("Item4", "Item5");
//		PairString p3 = new PairString("Item4", "Item6");
		data.add(p1);
		data.add(p4);
		data.add(p2);
		data.add(p3);
		System.out.println(data);
		largestItemAssociation(data);
	}

	public static List<String> largestItemAssociation(List<PairString> data) {

		Map<String, List<String>> map = new HashMap<>();

		for (PairString pair : data) {

			if (!map.containsKey(pair.first)) {
				map.put(pair.first, new ArrayList<>());
			}
			map.get(pair.first).add(pair.second);
		}

		Set<String> set = new HashSet<>();
		int prevSize = 0;
		List<String> res = new ArrayList<>();

		for (String s : map.keySet()) {

			List<String> mid = new ArrayList<>();
			if (!set.contains(s)) {
				mid.add(s);
				dfs(set, map, s, mid);
			}
			if (mid.size() > prevSize) {
				prevSize = mid.size();
				res = new ArrayList<>(mid);
			} else if (mid.size() == res.size()) {
				Collections.sort(res);
				Collections.sort(mid);
           System.out.println("5".compareTo("3"));
				if (res.get(0).compareTo(mid.get(0)) > 0) {
					prevSize = mid.size();
					res = new ArrayList<>(mid);
				}
			}
		}
		System.out.println(res.toString());

		return null;
	}

	static void dfs(Set<String> set, Map<String, List<String>> map, String s, List<String> mid) {

		set.add(s);

		for (String str : map.getOrDefault(s, new ArrayList<>())) {

			if (!set.contains(str)) {
				mid.add(str);
				dfs(set, map, str, mid);
			}
		}
	}
}