package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class House_robber_iii_337 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			int sum = 0;
			while (size-- > 0) {
				TreeNode node = q.remove();
				sum += node.val;
				q.add(node.left);
				q.add(node.right);
			}
			list.add(sum);
		}
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 0; i < list.size(); i++) {
			if (i % 2 == 0) {
				sum1 += list.get(i);
			} else {
				sum2 += list.get(i);
			}
		}
	}

	public static int rob(TreeNode root) {
		if (root == null)
			return 0;
		int c = 0;
		if (root.left != null) {
			c += rob(root.left.right);
			c += rob(root.left.left);
		}
		if (root.right != null) {
			c += rob(root.right.right);
			c += rob(root.right.left);
		}
		return Math.max(c + root.val, c);
	}
}