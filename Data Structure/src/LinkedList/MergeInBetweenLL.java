package LinkedList;

import LinkedList.LLImplementation.Node;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class MergeInBetweenLL {
	public static void main(String[] args) {
		LLImplementation list1 = new LLImplementation();
		LLImplementation list2 = new LLImplementation();
		list1.addLast(0);
		list1.addLast(1);
		list1.addLast(2);
		list1.addLast(3);
		list1.addLast(4);
		list1.addLast(5);

		list2.addLast(10001);
		list2.addLast(100002);
		list2.addLast(10003);
		list2.addLast(199994);
		list2.addLast(10005);
		list2.addLast(10006);
		mergeInBetween(list1.head, 3, 4, list2.head);
		Node temp = list1.head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public static Node mergeInBetween(Node list1, int a, int b, Node list2) {
		Node end=list1,start=null;
		for(int i=0;i<b;i++,end=end.next) {
			if(i==a-1) {
				start=end;
			}
		}
		
		start.next = list2;
		while (start.next != null) {
			start = start.next;
		}
		start.next=end.next;
		end.next=null;
		return list1;
		
//		Node temp = list1;
//		int i = 0;
//		while (temp != null) {
//			if (i == a - 1) {
//				for (i = a - 1; i < b; i++) {
//					temp.next = temp.next.next;
//				}
//				break;
//			}
//			i++;
//			temp = temp.next;
//
//		}
//		temp = list1;
//		Node t = null;
//		i = 0;
//		while (temp != null) {
//			if (i == a - 1) {
//				t = temp.next;
//				temp.next = list2;
//				break;
//			}
//			i++;
//			temp = temp.next;
//		}
//		temp = list2;
//		while (temp.next != null) {
//			temp = temp.next;
//		}
//		temp.next = t;
//		return list1;
	}
}
