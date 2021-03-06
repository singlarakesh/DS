package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
};

public class Populating_Next_Right116 {
	public static void main(String[] args) {

	}

	public Node connect(Node root) {
		if (root == null) {
			return null;
		}
		Queue<Node> q = new LinkedList<Node>();
		Queue<Node> hq = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {
			Node n = q.poll();
			if (q.isEmpty()) {
				n.next=null;
			} else {
				n.next=q.peek();
			}
			if(n.left!=null) {
				hq.add(n.left);
			}
			if(n.right!=null) {
				hq.add(n.right);
			}
			if(q.isEmpty()) {
				q=hq;
				hq=new LinkedList<Node>();
			}
		}
		return root;
	}
}
