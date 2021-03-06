package Graph;

import java.util.ArrayList;
import java.util.List;

public class implementation {
	static class Edge {
		int src;
		int dest;
		int wt;

		public Edge(int src, int dest, int wt) {
			super();
			this.src = src;
			this.dest = dest;
			this.wt = wt;
		}

	}

	public static void main(String[] args) {
		int V = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
		for (int i = 0; i < V; i++)
			adj.add(new ArrayList<Integer>());

		addEdge(adj, 0, 1);
		addEdge(adj, 0, 4);
		addEdge(adj, 1, 2);
		addEdge(adj, 1, 3);
		addEdge(adj, 1, 4);
		addEdge(adj, 2, 3);
		addEdge(adj, 3, 4);
//		printGraph(adj);
		boolean visited[] = new boolean[adj.size()];
		boolean b=isPathExist(adj, 3, 1,visited);
		System.out.println(b);
	}

	private static boolean isPathExist(ArrayList<ArrayList<Integer>> adj, int src, int dist, boolean visited[]) {
		// TODO Auto-generated method stub
		System.out.println(src);
		if (src == dist) {
			return true;
		}
		visited[src] = true;
		for (int i = 0; i < adj.get(src).size(); i++) {
			if (!visited[adj.get(src).get(i)]) {
				boolean b = isPathExist(adj, adj.get(src).get(i), dist, visited);
				if (b)
					return true;
			}
		}
		return false;
	}

	private static void printGraph(ArrayList<ArrayList<Integer>> adj) {
		// TODO Auto-generated method stub
		for (int i = 0; i < adj.size(); i++) {
			System.out.println("\nAdjacency list of vertex" + i);
			System.out.print("head");
			for (int j = 0; j < adj.get(i).size(); j++) {
				System.out.print(" -> " + adj.get(i).get(j));
			}
			System.out.println();
		}
	}

	private static void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j) {
		// TODO Auto-generated method stub
		adj.get(i).add(j);
		adj.get(j).add(i);
	}
}
