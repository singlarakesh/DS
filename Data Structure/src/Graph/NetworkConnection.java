package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NetworkConnection {
	public static void main(String[] args) {
		int connections[][] = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 2 } };
		makeConnected(6, connections);
	}

	public static int makeConnected(int n, int[][] connections) {
		if (connections.length < n - 1)
			return -1;
		List<Integer>[] graph = new List[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for (int[] c : connections) {
			graph[c[0]].add(c[1]);
			graph[c[1]].add(c[0]);
		}
		int component = 0;
		boolean[] visited = new boolean[n];
		for (int v = 0; v < n; v++) {
			if (!visited[v]) {
				component += dfs(v, graph, visited);
			}
		}
		System.out.println(component);
		return component-1;
	}

	private static int dfs(int src, List<Integer>[] graph, boolean[] visited) {
		// TODO Auto-generated method stub
		visited[src] = true;
		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		while (!q.isEmpty()) {
			int l = q.poll();
			List<Integer> list = graph[l];
			for (int v : list) {
				if (!visited[v]) {
					visited[v] = true;
					q.add(v);
				}
			}
		}
		return 1;
	}
}
