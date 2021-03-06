
public class LearningTree {
	Node root;
	static int minVal = Integer.MAX_VALUE;
	static int maxVal = Integer.MIN_VALUE;
	static int d = 0;

	public static void main(String[] args) {
		LearningTree tree = new LearningTree();
		tree.root = new Node(10);
		tree.root.left = new Node(12);
		tree.root.right = new Node(15);
		tree.root.left.left = new Node(25);
		tree.root.left.right = new Node(30);
		tree.root.right.left = new Node(36);
		System.out.println(findHt(tree.root));
		findDiameter(tree.root);
		System.out.println(d);
	}

	private static int findDiameter(Node root) {
		if (root == null)
			return 0;
		// TODO Auto-generated method stub
		int lh = findDiameter(root.left);
		int rh = findDiameter(root.right);
		int ht = Math.max(lh, rh) + 1;
		d = d > ht ? d : ht;
		return ht;
	}

	private static int findHt(Node root) {
		if (root == null)
			return 0;
		int lh = findHt(root.left);
		int rh = findHt(root.right);

		return Math.max(lh, rh) + 1;

	}

}
