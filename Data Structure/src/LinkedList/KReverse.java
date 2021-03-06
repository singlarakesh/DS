package LinkedList;

import java.util.*;

public class KReverse {
	public static void main(String[] args) throws Exception {
		Scanner scr = new Scanner(System.in);
		linked_list s = new linked_list();
		int n = scr.nextInt();
		int k = scr.nextInt();
		for (int i = 0; i < n; i++) {
			int num = scr.nextInt();
			s.addLast(num);
		}
		kthreverse(s, k);
		s.dislay();
	}

	public static class linked_list {
		private class node {
			int data;
			node next;
		}

		private node head;
		private node tail;
		private int size;

		public void addLast(int item) {
			// new node
			node nn = new node();
			nn.data = item;
			nn.next = null;
			// attach
			if (size == 0) {
				head = nn;
				tail = nn;
				tail.next = null;
				size++;
			} else {
				tail.next = nn;
				tail = nn;
				size++;
			}
			// summary update

		}

		public void addfirst(int item) {
			node n = new node();
			n.data = item;
			if (size == 0) {
				n.next = null;
				head = n;
				tail = n;
				size++;
			} else {
				n.next = head;
				head = n;
				size++;
			}

		}

		public int removefirst() throws Exception {
			if (size == 0) {
				throw new Exception("linked list is empty");
			}
			int t = head.data;
			if (size == 1) {
				head = null;
				tail = null;
				size--;
			} else {
				head = head.next;
				size--;
			}
			return t;
		}

		public void dislay() {
			node temp = head;
			while (temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
		}

	}

	public static void kthreverse(linked_list s, int k) throws Exception {
		linked_list prev = null;
		linked_list curr = null;
		while (s.size != 0) {

			curr = new linked_list();
			for (int i = 0; i < k; i++) {
				curr.addfirst(s.removefirst());
			}
			if (prev != null) {
				prev.tail.next = curr.head;
				prev.tail = curr.tail;
				prev.size += curr.size;
			} else {
				prev = curr;
			}
		}
		s.head = prev.head;
		s.tail = prev.tail;
		s.size = prev.size;
	}
}