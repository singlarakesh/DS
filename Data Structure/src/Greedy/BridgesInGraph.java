package Greedy;

import java.util.LinkedList;

class Graph {
	int v;
	LinkedList<Integer> adj[];
	static final int NIL = -1;
	  int time = 0;
	public Graph(int v) {
		// TODO Auto-generated constructor stub
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int u, int v) {
		adj[u].add(v);
		adj[v].add(u);
	}

	public void bridge() {
		// TODO Auto-generated method stub
		boolean visited[] = new boolean[v];
        int disc[] = new int[v];
        int low[] = new int[v];
		int parent[] = new int[v];
		for (int i = 0; i < v; i++) {
			parent[i] = NIL;
			visited[i] = false;
		}
		for (int i = 0; i < v; i++) {
			if (!visited[i]) {
		      bridgeUtil(visited,i,parent)
			}
		}
	}

	private void bridgeUtil(boolean[] visited, int i, int[] parent) {
		// TODO Auto-generated method stub
		visited[u]=
	}
}

public class BridgesInGraph {
	public static void main(String[] args) {
		Graph g1 = new Graph(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 1);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		g1.bridge();
	}
}
