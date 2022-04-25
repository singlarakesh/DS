package GreedyAproach;

import java.util.HashMap;
import java.util.Map;

class ListNode {
	String val;
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

public class RemoveDuplicateList2 {
	public static void main(String[] args) {

	}

	public ListNode deleteDuplicates(ListNode head) {
		Map<String, Integer> map = new HashMap<>();
		ListNode cur = head;
		while (cur != null) {
			if (map.containsKey(cur.val)) {
				map.put(cur.val, map.get(cur.val + 1));
			} else {
				map.put(cur.val, 1);
			}

			cur = cur.next;
		}
		cur = head;
		ListNode prev = head;
		while (cur != null) {
			while (map.get(cur.val)>1) {
				cur=cur.next;
			}
            prev.next=cur;
		}

	}
}
