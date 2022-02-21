package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindPath {
	public static void main(String[] args) {
		int edge[][] = { { 0, 1 }, { 1, 2 }, { 2, 0 } };
		validPath(3, edge, 0, 2);
	}

	public static boolean validPath(int n, int[][] edges, int start, int end) {
		List<Integer> graph[] = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		for (int j[] : edges) {
			graph[j[0]].add(j[1]);
			graph[j[1]].add(j[0]);
		}
		boolean visited[] = new boolean[n];
		System.out.println(dfs(graph, start, end, visited));;
		return true;
	}

	private static boolean dfs(List<Integer>[] graph, int start, int end, boolean visited[]) {
		// TODO Auto-generated method stub
		if (start == end) {
			return true;
		}
		visited[start] = true;
		for (int nb : graph[start]) {
			if (!visited[nb]) {
				boolean b = dfs(graph, nb, end, visited);
				if (b)
					return true;
			}
		}
		return false;
	}
}
