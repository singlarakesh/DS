package Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class MyGraph {
	private List<Integer> adj[];

	public MyGraph(int v) {
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int source, int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}

	public void display() {
		for (int i = 0; i < adj.length; i++) {
			System.out.println(i + "-->" + adj[i]);
		}
	}

	public int bfs(int source, int dest) {
		int dist = 0;
		Queue<Integer> q = new LinkedList<>();
		boolean visited[] = new boolean[adj.length];
		q.add(source);
		visited[source] = true;
		while (!q.isEmpty()) {
			int s = q.poll();
			if (s == dest)
				return dist;
			List<Integer> list = adj[s];
			for (int i = 0; i < list.size(); i++) {
				if (!visited[list.get(i)]) {
					q.add(list.get(i));
					visited[list.get(i)] = true;
				}
			}
			dist++;
		}
		return -1;
	}

	public void dfs(int source, int dest, String ans, boolean visited[]) {
		if (source == dest) {
			System.out.println(ans+source);
			return;
		}
		visited[source] = true;
		ans+=source;
		for (int i : adj[source]) {
			if (!visited[i])
				dfs(i, dest, ans, visited);
		}
		visited[source] = false;
	}
    public void dijakstra(int source,int dest) {
    	
    }
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		System.out.println("Enter number of vertices and edges");
		int e = scr.nextInt();
		int v = scr.nextInt();
		MyGraph g = new MyGraph(v);
		for (int i = 0; i < e; i++) {
			System.out.println("Enter Source And Destination");
			int source = scr.nextInt();
			int destination = scr.nextInt();
			g.addEdge(source, destination);
		}
		g.display();
//		System.out.println(g.bfs(0, 4));
//		boolean visited[] = new boolean[v];
//		g.dfs(0, 4, "", visited);
		;
	}
}
