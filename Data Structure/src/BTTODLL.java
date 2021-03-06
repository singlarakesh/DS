class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		left = right = null;
	}
}

public class BTTODLL {
	Node head;
	Node prev;
	Node root;

	public static void main(String[] args) {
		// Let us create the tree as shown in above diagram
		BTTODLL tree = new BTTODLL();
		tree.root = new Node(10);
		tree.root.left = new Node(12);
		tree.root.right = new Node(15);
		tree.root.left.left = new Node(25);
		tree.root.left.right = new Node(30);
		tree.root.right.left = new Node(36);

		// convert to DLL
//		tree.BinaryTree2DoubleLinkedList(tree.root);
//		tree.printList(tree.head);
		tree.printBoundary(tree.root);
	}

	private void printBoundary(Node root) {
		// TODO Auto-generated method stub
		System.out.println(root.data);
		printBoundaryLeft(root.left);
		printLeaves(root.left);
		printLeaves(root.right);
		printBoundaryRight(root.right);

	}

	private void printLeaves(Node node) {
		// TODO Auto-generated method stub
		if (node.left == null && node.right == null)
			System.out.println(node.data);
		if (node.left != null)
			printLeaves(node.left);
		if (node.right != null)
			printLeaves(node.right);
	}

	private void printBoundaryLeft(Node root) {
		// TODO Auto-generated method stub
		if (root.left != null) {
			System.out.println(root.data);
			printBoundaryLeft(root.left);
		} else if (root.right != null) {
			System.out.println(root.data);
			printBoundaryLeft(root.right);
		}

	}

	private void printBoundaryRight(Node root) {
		// TODO Auto-generated method stub
		if (root.right != null) {
			printBoundaryRight(root.right);
			System.out.println(root.data);
		} else if (root.left != null) {
			printBoundaryRight(root.left);
			System.out.println(root.data);
		}

	}

	private void BinaryTree2DoubleLinkedList(Node root) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		BinaryTree2DoubleLinkedList(root.left);
		if (prev == null)
			head = root;
		else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		BinaryTree2DoubleLinkedList(root.right);
	}

	void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.right;
		}
	}
}
