package Heap;

import java.util.PriorityQueue;

public class MaxElem {
	public static void main(String[] args) {
		int ar[] = { 3, 2, 1, 5, 6, 4 };
		int k=2;
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int i : ar) {
			q.add(i);
			if(q.size()>2)
				q.poll();
		}
		System.out.println(q.peek());
		PriorityQueue<Integer> qmin = new PriorityQueue<>((a,b)->b-a);
		for (int i : ar) {
			qmin.add(i);
			if(qmin.size()>2)
				qmin.poll();
		}
		System.out.println(qmin.peek());
	}
}
