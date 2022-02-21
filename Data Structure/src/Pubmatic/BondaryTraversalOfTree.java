package Pubmatic;

class Node {
	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right = null;
	}
}

public class BondaryTraversalOfTree {
	Node root;

	public static void main(String[] args) {
		BondaryTraversalOfTree tree = new BondaryTraversalOfTree();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);
		tree.root.right = new Node(22);
		tree.root.right.right = new Node(25);
		tree.printBoundary(tree.root);
	}

	private void printBoundary(Node root) {
		// TODO Auto-generated method stub
		if (root == null)
			return;

		System.out.print(root.data + " ");

		printLeftBoundar(root.left);
		printleaveNodes(root.left);
		printleaveNodes(root.right);
		printRightBoundar(root.right);

	}

	private void printRightBoundar(Node node) {
		// TODO Auto-generated method stub
		if (node == null)
			return;
		if (node.right != null) {
			System.out.println(node.data);
			printRightBoundar(node.right);
		} else if (node.left != null) {
			System.out.println(node.data);
			printRightBoundar(node.left);
		}

	}

	private void printleaveNodes(Node node) {
		// TODO Auto-generated method stub
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			System.out.print(node.data + " ");
			return;
		}
		printleaveNodes(node.left);
		printleaveNodes(node.right);
	}

	private void printLeftBoundar(Node node) {
		// TODO Auto-generated method stub
		if (node == null) {
			return;
		}
		if (node.left != null) {
			System.out.print(node.data + " ");
			printLeftBoundar(node.left);
		} else if (node.right != null) {
			System.out.print(node.data + " ");
			printLeftBoundar(node.right);
		}
	}
}
