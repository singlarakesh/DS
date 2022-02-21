package LinkedList;



public class MergeTwoSortedLL {
	public static void main(String[] args) {
		LLImplementation list1 = new LLImplementation();
		list1.addLast(5);
		list1.addLast(10);
		list1.addLast(15);
		LLImplementation list2 = new LLImplementation();
		list2.addLast(2);
		list2.addLast(3);
		list2.addLast(20);
//		mergeTwoLists(list1, list2,null);
	}

//Correct Implementation
	public ListNode mergeTwoLists(ListNode list1, ListNode list2, ListNode curr) {
		if (list1 == null) {
			return list2;
		}

		if (list2 == null) {

			return list1;
		}

		if (list1.val > list2.val) {
			ListNode n = new ListNode(list2.val);
			curr = n;
			curr.next = mergeTwoLists(list1, list2.next, null);
		} else {
			ListNode n = new ListNode(list1.val);
			curr = n;
			curr.next = mergeTwoLists(list1.next, list2, null);
		}
		return curr;
	}
}
