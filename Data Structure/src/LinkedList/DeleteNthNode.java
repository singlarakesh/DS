package LinkedList;

class Node {
	int val;
	Node next;

	Node(int val) {
		this.val = val;
		this.next = null;
	}
}

public class DeleteNthNode {
	public static void main(String[] args) {
		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(3);
		n.next.next.next = new Node(4);
		n.next.next.next.next = new Node(5);
		removeNthNode(n, 2);
	}

	private static void removeNthNode(Node head, int i) {
		// TODO Auto-generated method stub
		Node first = head;
		Node second = head;
		int k = i;
		while (k-- > 0) {
			second = second.next;
		}
		while (second.next != null) {
			first = first.next;
			second = second.next;
		}

		first.next = first.next.next;
	}
}
