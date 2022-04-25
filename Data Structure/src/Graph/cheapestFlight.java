package Graph;

import java.util.ArrayList;

class dstPoint {
	int d;
	int cost;

	dstPoint(int d, int cost) {
		this.d = d;
		this.cost = cost;
	}
}

public class cheapestFlight {
	public static void main(String[] args) {
		int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
		int src = 0;
		int dst = 3, k = 1;
		ArrayList<ArrayList<dstPoint>> adj = creatingGraph(flights);
		System.out.println(adj);
	}

	private static ArrayList<ArrayList<dstPoint>> creatingGraph(int[][] flights) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<dstPoint>> adj = new ArrayList<ArrayList<dstPoint>>(flights.length);
		System.out.println(adj);
		for (int i = 0; i < flights.length; i++) {
			if (adj.get(flights[i][0]) == null) {
				adj.set(flights[i][0], new ArrayList<dstPoint>());
			} else {
				ArrayList<dstPoint> list = new ArrayList<dstPoint>();
				list.add(new dstPoint(flights[i][1], flights[i][2]));
				adj.set(flights[i][0], list);
			}
		}
		return adj;
	}
}
