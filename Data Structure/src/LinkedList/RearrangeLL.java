package LinkedList;

import java.util.Stack;

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		next = null;
	}
}

public class RearrangeLL {
	public static void main(String[] args) {
		// Let us create linked list 1->2->3->4->5
		Node head = null;

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next = new Node(8);

		System.out.println("Given linked list");
		printList(head);
		arrange(head);
		System.out.println("\nAfter rearrangement");
		printList(head);
	}

	private static void arrange(Node head) {
		// TODO Auto-generated method stub
		Stack<Node> s = new Stack<Node>();
		Node mid = findNode(head);
		Node temp = mid;
		while (temp != null) {
			s.push(temp);
			temp = temp.next;
		}
		Node current = head;
		while (!s.isEmpty()) {
			Node next = current.next;
			Node t = s.pop();
			current.next = t;
			if(s.isEmpty()) {
				t.next=null;
				break;}
			t.next=next;
			current=next;

		}
	}

	private static Node findNode(Node head) {
		// TODO Auto-generated method stub
		Node start = head;
		Node sstart = head;
		while (sstart != null && sstart.next != null) {
			start = start.next;
			sstart = sstart.next.next;
		}
		return start;
	}

	static void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
}
