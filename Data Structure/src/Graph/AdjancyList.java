package Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class AdjancyList {
//	public static void main(String[] args) {
//		List<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
//		Scanner scr=new Scanner(System.in);
//		int u=scr.nextInt();
//		int v=scr.nextInt();
//		
//			adj.get(u).add(v);
//	}
	int v;
	LinkedList<Integer> adj[];

	public AdjancyList(int v) {
		// TODO Auto-generated constructor stub
		this.v = v;
		this.adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int u, int v) {
		adj[u].add(v);
	}

	public static void main(String[] args) {
		AdjancyList g = new AdjancyList(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		g.BFS(2);
		boolean v[] = new boolean[g.v];
		g.DFS(2, v);
	}

	private void DFS(int i, boolean[] visited) {
		// TODO Auto-generated method stub
		visited[i] = true;
		System.out.println(i);
		Iterator<Integer> l = adj[i].listIterator();
		while (l.hasNext()) {
			int d=l.next();
			if(!visited[d]) {
				DFS(d, visited);
			}
		}

	}

	private void BFS(int val) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<Integer>();
		boolean visi[] = new boolean[v];

		q.add(val);
		visi[val] = true;
		while (!q.isEmpty()) {
			int d = q.poll();
			System.out.println(d + " ");
			Iterator<Integer> i = adj[d].listIterator();
			while (i.hasNext()) {
				int rem = i.next();
				if (!visi[rem]) {
					q.add(rem);
					visi[rem] = true;
				}
			}
		}

	}
}
