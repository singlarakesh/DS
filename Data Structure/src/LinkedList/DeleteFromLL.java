package LinkedList;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DeleteFromLL {
	public static void main(String[] args) throws Exception {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
//		int tc = scr.nextInt();
//		List<Integer> list = new LinkedList<>();
		Linked_List list = new Linked_List();
		for (int j = 0; j < n; j++) {
			int num = scr.nextInt();
			list.addLast(num);
		}
		int k = scr.nextInt();
		list.kReverse(list, k);
		list.display();
//		list.display();
//		list.remove(2);
//		list.display();
//		System.out.println(list);
//		for (int i = 0; i < tc; i++) {
//			int m = scr.nextInt();
//
//			int item = list.remove(m);
//			System.out.println(list);
//
//		}

	}


	public static class Linked_List {
		Node head;
		Node tail;
        int size;
		public static class Node {
			int data;
			Node next;
		}

		public Linked_List() {
			// TODO Auto-generated constructor stub
		}

		public void addLast(int data) {
			Node nn = new Node();
			nn.data = data;
			if (head == null) {
				head = nn;
				tail = nn;
			} else {
				tail.next = nn;
				nn.next = null;
				tail = nn;
			}
		}

		public void display() {
			displayLL(head);
		}

		public void displayLL(Node nn) {
			System.out.println(nn.data);
			if (nn.next != null) {
				displayLL(nn.next);
			}
		}

		public void remove(int index) {
			int c = 0;
			removeIndex(c, index, head, head);
		}

		private void removeIndex(int c, int index, Node prev, Node nn) {
			// TODO Auto-generated method stub
			if (index == 0) {
				head=head.next;
				return;
			}
			if (c == index) {
				prev.next = nn.next;
				nn.next = null;
				return;
			}
			removeIndex(c++, index, nn, nn.next);
		}
		private static void kReverse(Linked_List list, int k) {
			// TODO Auto-generated method stub
			Linked_List prev;
			while(this.size>0) {}
			
			
		}
	}
}
