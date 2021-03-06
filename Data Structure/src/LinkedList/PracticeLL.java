package LinkedList;

import java.util.Scanner;

import LinkedList.PracticeLL.LL_List.Node;

public class PracticeLL {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner scr = new Scanner(System.in);
		LL_List s = new LL_List();
		int n = scr.nextInt();
//		int k = scr.nextInt();
		for (int i = 0; i < n; i++) {
			int num = scr.nextInt();
			s.addLast(num);
		}
//		kthreverse(s, k);
//		lldeleteDuplicates(s.head);
	     removeDuplicatedFromSorted(s.head);
		s.display();
	}

	private static void removeDuplicatedFromSorted(Node head) {
		// TODO Auto-generated method stub
		Node curr = head;
		Node prev = null;
		int c = 0;
		while (curr.next != null) {
			if (curr.data == curr.next.data) {
				Node nexto = curr.next.next;
				curr.next.next = null;
				curr.next = nexto;
				c++;
			} else {
				if (c != 0) {
					if (prev != null) {
						Node temp = curr;
						prev.next = curr.next;				
						curr = curr.next;
						temp.next = null;
					}else {
						Node temp = curr;
						prev = curr.next;
						head=curr.next;
						curr = curr.next;
						temp.next = null;
					}
					c=0;
				} else {
					prev = curr;
					curr = curr.next;
				}
			}
			
		}
//		if (c != 0) {
//			if (prev != null) {
//				Node temp = curr;
//				prev.next = curr.next;
//				curr = curr.next;
//				temp.next = null;
//			}else {
//				Node temp = curr;
//				prev = curr.next;
//				head=curr.next;
//				curr = curr.next;
//				temp.next = null;
//			}
	}

	private static void lldeleteDuplicates(Node head) {
		// TODO Auto-generated method stub
		Node curr = head;
		Node nextto;
		while (curr.next != null) {
			if (curr.data == curr.next.data) {
				nextto = curr.next.next;
				curr.next.next = null;
				curr.next = nextto;
			} else {
				curr = curr.next;
			}
		}
	}

	private static void kthreverse(LL_List s, int k) throws Exception {
		// TODO Auto-generated method stub
		LL_List prev = null;
		LL_List curr = null;
		while (s.size != 0) {
			curr = new LL_List();
			int i = 0;
			while (i < k && s.size != 0) {
				curr.addFirst(s.removeFirst());
				i++;
			}
			if (prev == null) {
				prev = curr;
			} else {
				prev.tail.next = curr.head;
				prev.tail = curr.tail;
				prev.size += curr.size;
			}

		}
		s.head = prev.head;
		s.tail = prev.tail;
		s.size = prev.size;
	}

	public static class LL_List {
		class Node {
			int data;
			Node next;
		}

		private Node head;
		private Node tail;
		private int size;

		public void addFirst(int data) {
			Node nn = new Node();
			nn.data = data;
			nn.next = null;
			if (size == 0) {
				this.head = nn;
				this.tail = nn;
			} else {
				nn.next = head;
				head = nn;
			}
			size++;
		}

		public void addLast(int data) {
			Node nn = new Node();
			nn.data = data;
			nn.next = null;
			if (size == 0) {
				this.head = nn;
				this.tail = nn;
			} else {
				tail.next = nn;
				tail = nn;
			}
			size++;
		}

		public int removeFirst() throws Exception {
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

//		public void removeLast() {
//			Node nn=getNodeAt(size-1);
//			nn.next=null;
//			tail=nn;
//		}
//		private Node getNodeAt(int i) {
//			// TODO Auto-generated method stub
//			return null;
//		}
		public void display() {
			Node temp = head;
			while (temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
		}
	}
}
