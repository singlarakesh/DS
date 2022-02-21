package LinkedList;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import LinkedList.LLImplementation.Node;

public class ReOrderList {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		LLImplementation list = new LLImplementation();

		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(5);
		list.addLast(6);
		traverse(list.head);
	}

	private static void traverse(Node head) {
		// TODO Auto-generated method stub
		// find mid
		Node mid = findMid(head);
		// reverse from mid
		reverseFromMid(mid);

		ReOrder(head, mid.next, mid);
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	private static void ReOrder(Node left, Node right, Node m) {
		while (left != m) {
			m.next = right.next;
			Node t = left.next;
			left.next = right;
			Node p = right.next;
			right.next = t;
			left = t;
			right = p;
		}
	}

	private static void reverseFromMid(Node root) {
		// TODO Auto-generated method stub
		Node nn = root.next;
		Node curr = nn;
		Node next = null;
		Node prev = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		root.next = prev;

	}

	private static Node findMid(Node head) {
		// TODO Auto-generated method stub
		Node slow = head;
		Node fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

}
