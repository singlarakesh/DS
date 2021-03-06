
public class Tree {
	private TreeNode root;

	public void intsert(int val) {
		if (root == null) {
			root = new TreeNode(val);
		} else {
			root.insert(val);
		}
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.intsert(25);
		tree.intsert(20);
		tree.intsert(15);
		tree.intsert(14);
		tree.intsert(27);
		tree.intsert(30);
		tree.intsert(29);
		tree.intsert(26);
		tree.intsert(22);
		tree.intsert(32);
		tree.travelsalInorder();
	}

	public void delete(int val) {
		root = delete(root, val);
	}

	private TreeNode delete(TreeNode subtreeNode, int val) {
		if (subtreeNode == null)
			return subtreeNode;
		if (val < subtreeNode.getData()) {
			subtreeNode.setLeftChild(delete(subtreeNode.getLeftChild(), val));
		} else if (val > subtreeNode.getData()) {
			subtreeNode.setRightChild(delete(subtreeNode.getRightChild(), val));
		} else {
			if (subtreeNode.getLeftChild() == null) {
				return subtreeNode.getRightChild();
			} else if (subtreeNode.getRightChild() == null) {
				return subtreeNode.getLeftChild();
			} else {
				subtreeNode.setData(subtreeNode.getRightChild().getMin());
				subtreeNode.setRightChild(delete(subtreeNode.getRightChild(),subtreeNode.getData()));
			}
		}
		return subtreeNode;
	}

	private void travelsalInorder() {
		root.travelsalInorder();
		this.delete(20);
		System.out.println();
		root.travelsalInorder();
	}
}
