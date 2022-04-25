package com.craftAssignment.Intuit;

class ListNode {
	int val;
	ListNode next;

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

}

public class RotateList {
	public static void main(String[] args) {
		ListNode node = new ListNode(10);
		node.next = new ListNode(20);
		node.next.next = new ListNode(30);
		node.next.next.next = new ListNode(20);
		printList(node);
		int k = 2;
		rotateList(node, k);
	}

	private static void rotateList(ListNode node, int k) {
		// TODO Auto-generated method stub
		if (node == null) {
			return;
		}
		int size = getSize(node);
		k = k % size;
		if (k == 0) {
			return;
		}
		ListNode start = node;
		ListNode fast = node;
		while (k-- > 0) {
			fast = fast.next;
		}
		while (fast.next != null) {
			start = start.next;
			fast = fast.next;
		}
		ListNode temp = start.next;
		start.next = null;
		fast.next = node;
		return temp;
	}

	private static int getSize(ListNode node) {
		// TODO Auto-generated method stub
		int size = 0;
		ListNode temp = node;
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
			size++;
		}
		return size;
	}

	private static void printList(ListNode node) {
		ListNode temp = node;
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}

	}

}
