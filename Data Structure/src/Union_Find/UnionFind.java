package Union_Find;

class Graph {
	int V, E;
	Edge edge[];

	class Edge {
		int src, dest;
	}

	Graph(int v, int e) {
		V = v;
		E = e;
		edge = new Edge[E];
		for (int i = 0; i < e; i++) {
			edge[i]=new Edge();
		}
	}
	int find(int parent[],int i) {}
}

public class UnionFind {
	public static void main(String[] args) {

	}
}
