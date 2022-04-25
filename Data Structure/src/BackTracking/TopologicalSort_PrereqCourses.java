package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class TopologicalSort_PrereqCourses {
	public static void main(String[] args) {

	}

	static String midCourse(String[][] courses) {

		// [course, prerequisite]

		Map<String, Integer> inDegree = new HashMap<>();
		Map<String, List<String>> adjacency = new HashMap<>();

		for (String[] course : courses) {
			adjacency.computeIfAbsent(course[1], k -> new ArrayList<>()).add(course[0]);
			inDegree.putIfAbsent(course[1], 0);
			inDegree.put(course[0], inDegree.getOrDefault(course[0], 0) + 1);
		}

		List<String> courseInOrder = new ArrayList<>();
		Queue<String> kahn = new LinkedList<>();

		for (Map.Entry<String, Integer> entry : inDegree.entrySet()) {
			if (entry.getValue() == 0) {
				kahn.add(entry.getKey());
			}
		}

		while (!kahn.isEmpty()) {
			String course = kahn.poll();
			courseInOrder.add(course);

			for (String adj : adjacency.getOrDefault(course, new ArrayList<>())) {
				inDegree.put(adj, inDegree.get(adj) - 1);
				if (inDegree.get(adj) == 0) {
					kahn.add(adj);
				}
			}
		}

		return courseInOrder.get(courseInOrder.size() / 2);

	}

	public String halfwayCourse(String[][] courses) {

		// Create adjacency list
		Map<String, List<String>> map = new HashMap<>();

		for (int i = 0; i < courses.length; i++) {

			String course = courses[i][1];
			String prereq = courses[i][0];

			if (map.containsKey(course)) {
				List<String> list = map.get(course);
				list.add(prereq);
			} else {
				List<String> list = new ArrayList<>();
				list.add(prereq);
				map.put(course, list);
			}
			map.putIfAbsent(prereq, new ArrayList<String>());
		}

		Set<String> visited = new HashSet<>();
		String[] allCourses = map.keySet().toArray(new String[map.keySet().size()]);
		List<String> results = new ArrayList<>();

		for (String course : allCourses) {
			helper(course, results, visited, map);
		}

		System.out.println(Arrays.toString(results.toArray()));
		int halfway = (int) Math.floor(results.size() / 2);

		return results.get(halfway);
	}

	public void helper(String node, List<String> results, Set<String> visited, Map<String, List<String>> map) {

		if (visited.contains(node))
			return;

		visited.add(node);
		List<String> prereqs = map.get(node);

		for (String course : prereqs) {
			helper(course, results, visited, map);
		}
		results.add(node);
	}
}
