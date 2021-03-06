
public class TreeNode {
	private int data;
	private TreeNode leftChild;
	private TreeNode rightChild;

	public void insert(int val) {
		if (val == data) {
			return;
		}
		if (val < data) {
			if (leftChild == null) {
				leftChild = new TreeNode(val);
			} else {
				leftChild.insert(val);
			}
		} else {
			if (rightChild == null) {
				rightChild = new TreeNode(val);
			} else {
				rightChild.insert(val);
			}
		}
	}


	private TreeNode delete(TreeNode subtreeNode, int val) {
		return subtreeNode;
	}
//	public boolean delete(int val) {
//		boolean b = false;
//		if (val == data) {
//			return true;
//		} else if (val < data && leftChild != null) {
//			b = leftChild.delete(val);
//			if (b)
//				leftChild = null;
//		} else if (val > data && rightChild != null) {
//			b=rightChild.delete(val);
//			if (b)
//				rightChild = null;
//		}
//		return false;
//	}

	public void travelsalInorder() {
		if (leftChild != null) {
			leftChild.travelsalInorder();
		}
		System.out.print(data + ",");
		if (rightChild != null) {
			rightChild.travelsalInorder();
		}
	}

	public int getMin() {
		if (leftChild == null) {
			return data;
		} else {
			return leftChild.getMin();
		}
	}

	public TreeNode(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}
}
