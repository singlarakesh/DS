package com.craftAssignment.Intuit;

import java.util.Vector;

public class PriorityQueue {
	private Vector<Integer> A;

	public PriorityQueue() {
		A = new Vector();
	}

	public PriorityQueue(int capacity) {
		A = new Vector(capacity);
	}

	private int parent(int i) {
		if (i == 0)
			return 0;
		return (i - 1) / 2;
	}

	private int leftChild(int i) {
		return 2 * i + 1;
	}

	public void heapify_up(int i) {
		if(i>0 && parent(i))
	}

	void swap(int x, int y) {
		// swap with a child having greater value
		Integer temp = A.get(x);
		A.setElementAt(A.get(y), x);
		A.setElementAt(temp, y);
	}

	private int rightChild(int i) {
		return 2 * i + 2;
	}

	public static void main(String[] args) {

	}
}
