package LinkedList;

class ListNode {
	int val;
	ListNode next;
	int carry;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	ListNode(int val, ListNode next, int carry) {
		this.val = val;
		this.next = next;
		this.carry = carry;
	}
}

public class linkedlistATN {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int s1 = size(l1);
		int s2 = size(l2);
		if (s1 == s2) {
			addTwoNumber(l1, l2);
		} else {
		}

	}

	private ListNode addTwoNumber(ListNode l1, ListNode l2) {
		// TODO Auto-generated method stub
		if (l1.next == null && l2.next == null) {
			int n = l1.val + l2.val;
			int carry = n / 10;
			ListNode node = new ListNode(n % 10, null, carry);
			return node;
		}
		ListNode nn = addTwoNumber(l1.next, l2.next);
		int n = l1.val + l2.val;
		int carry = n / 10;
		ListNode node = new ListNode(n % 10, null, carry);
	}

	private int size(ListNode l1) {
		// TODO Auto-generated method stub
		int size = 0;
		while (l1 != null) {
			l1 = l1.next;
			size++;
		}
		return size;
	}

	// Function to print linked list
	void printlist(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

}

//This code is contributed by Rishabh Mahrsee
