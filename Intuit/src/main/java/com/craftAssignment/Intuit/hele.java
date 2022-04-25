package com.craftAssignment.Intuit;

class BSTNode {
	int val;
	BSTNode left;
	BSTNode right;

	public BSTNode(int val) {
		// TODO Auto-generated constructor stub
		this.val = val;
	}

	public BSTNode(int val, BSTNode left, BSTNode right) {
		// TODO Auto-generated constructor stub
		this.val = val;
		this.left = left;
		this.right = right;
	}

}

public class hele {
	public static void main(String[] args) {
		BSTNode root = new BSTNode(50);
		root.left = new BSTNode(30);
		root.left.right = new BSTNode(40);
		root.left.left = new BSTNode(20);
		root.right = new BSTNode(70);
		root.right.right = new BSTNode(80);
		root.right.left = new BSTNode(60);
		searchAndInsert(root, 10);
		printInorder(root);
	}

	private static BSTNode searchAndInsert(BSTNode root, int newValue) {
		// TODO Auto-generated method stub
		if (root == null) {
			BSTNode node = new BSTNode(newValue);
			return node;
		}
		if (root.val > newValue) {
			root.left = searchAndInsert(root.left, newValue);
		} else {
			root.right = searchAndInsert(root.right, newValue);
		}
		return root;
	}

	private static void printInorder(BSTNode root) {
		if (root == null)
			return;
		printInorder(root.left);
		System.out.println(root.val);
		printInorder(root.right);

	}

}
