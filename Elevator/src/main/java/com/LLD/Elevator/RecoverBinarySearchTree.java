package com.LLD.Elevator;

class TreeNode {
	int val;
	TreeNode left, right;

	public TreeNode(int key) {
		val = key;
		left = right = null;
	}
}

public class RecoverBinarySearchTree {
	TreeNode root;

	RecoverBinarySearchTree() {
		root = null;
	}

	public static void main(String[] args) {
		// create an object of Tree
		RecoverBinarySearchTree tree = new RecoverBinarySearchTree();

		// create nodes of tree
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(12);
		tree.root.right = new TreeNode(9);

		// create child nodes of left child
		tree.root.left.left = new TreeNode(5);
		tree.root.left.right = new TreeNode(6);

		recoverBST(tree.root, new TreeNode(Integer.MIN_VALUE), new TreeNode(Integer.MAX_VALUE));
	}

	private static void recoverBST(TreeNode root, TreeNode min, TreeNode max) {
		if(root==null)
			return;
		if (root.val < min.val) {
			int temp = root.val;
			root.val = min.val;
			min.val = temp;
			return;
		}
		if (root.val > max.val) {
			int temp = root.val;
			root.val = max.val;
			max.val = temp;
			return;
		}
		recoverBST(root.left, min, root);
		recoverBST(root.right, root, max);
	}
}
