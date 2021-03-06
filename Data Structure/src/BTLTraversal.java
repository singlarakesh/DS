import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

class TNode {
	int val;
	TNode left;
	TNode right;
	TNode next;

	TNode() {
	}

	TNode(int val) {
		this.val = val;
	}

	TNode(int val, TNode left, TNode right) {
		this.val = val;
		this.right = right;
		this.left = left;
	}

}

class VPair {
	TNode node = null;
	int h = 0;

	public VPair(TNode root, int h) {
		this.node = root;
		this.h = h;
	}
}

public class BTLTraversal {
	static int c = 0;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		TNode root = new TNode();
		root.val = 1;
		root.left = new TNode(2);
		root.right = new TNode(3);
		root.left.left = new TNode(4);
		root.left.right = new TNode(5);
		root.right.left = new TNode(6);
		root.right.right = new TNode(7);
//		root.right.left.right = new TNode(8);

//		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
//		verticleView(root, 0, map);
//		verticleView(root, map);
//		List<List<Integer>> res = new ArrayList<List<Integer>>();
//		for (int i = min; i <= 0; i++) {
//			res.add(map.get(i));
//		}
//		for (int i = 1; i <= max; i++) {
//			res.add(map.get(i));
//		}
//		System.out.println();
//		lca(root,4,5);
//		System.out.println(distanceBtwNode(root, 4, 5));
//		System.out.println(countPairs(root, 3));
//		System.out.println(calcSize(root));

//		System.out.println(findHeight(root));
//		System.out.println(findMaxEle(root));
//		System.out.println(leftView(root));
//		zigzag(root);
//		PopulatingNextPointer(root);
//		prinAllNodeAtK(root, 2);
		widthOfBinaryTre(root);
		
		System.out.println(maxi);
//		return max;
	}
	static int maxi=Integer.MIN_VALUE;

	public static int widthOfBinaryTre(TNode root) {
		if (root == null) {
			return 0;
		}
		int lh = widthOfBinaryTre(root.left);
		int rh = widthOfBinaryTre(root.right);
		maxi = Math.max(maxi, lh + rh);
		return Math.max(lh, rh) + 1;
	}

//	private static void verticleView(TNode root, int v, Map<Integer, List<Integer>> map) {
//		// TODO Auto-generated method stub
//		if (root == null) {
//			return;
//		}
//		if (v < min) {
//			min = v;
//		}
//		if (v > max) {
//			max = v;
//		}
//		if (map.containsKey(v)) {
//			List<Integer> list = map.get(v);
//			list.add(root.val);
//			map.put(v, list);
//		} else {
//			List<Integer> list = new ArrayList<>();
//			list.add(root.val);
//			map.put(v, list);
//		}
//		verticleView(root.left, v - 1, map);
//		verticleView(root.right, v + 1, map);
//	}

	private static int prinAllNodeAtK(TNode root, int k) {
		// TODO Auto-generated method stub
		if (root == null) {
			return k;
		}
		prinAllNodeAtK(root.left, k);
		prinAllNodeAtK(root.right, k);
	}

	private static void PopulatingNextPointer(TNode root) {
		// TODO Auto-generated method stub
		Queue<TNode> q = new LinkedList<TNode>();
		q.add(root);
		while (!q.isEmpty()) {
			Queue<TNode> res = q;
			int size = res.size();
			while (size-- > 0) {
				TNode node = q.poll();
				if (!q.isEmpty()) {
					node.next = q.peek();
				} else {
					node.next = null;
				}
				System.out.print(node.next);
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
			}
			System.out.println();
		}
	}

	private static void verticleView(TNode root, Map<Integer, List<Integer>> map) {
		// TODO Auto-generated method stub
		Deque<VPair> q = new LinkedList<VPair>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		q.addLast(new VPair(root, 0));
		int max1 = 0;
		int min1 = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				VPair rp = q.removeFirst();
				map.putIfAbsent(rp.h, new ArrayList<>());
				map.get(rp.h).add(rp.node.val);

				if (rp.node.left != null) {
					q.addLast(new VPair(rp.node.left, rp.h - 1));
				}
				if (rp.node.right != null) {
					q.addLast(new VPair(rp.node.right, rp.h + 1));
				}
				max1 = Math.max(max1, rp.h);
				min1 = Math.min(min1, rp.h);
			}
		}

		for (int i = min1; i <= 0; i++) {
			res.add(map.get(i));
		}
		for (int i = 1; i <= max1; i++) {
			res.add(map.get(i));
		}
		System.out.println(res);
	}

	// Delete Node
//	https://youtu.be/5_AZcOOc-kM
//	Bigger BST tre
//	https://youtu.be/UGsJz8fSYp0
//Add a node to BST
	public static TNode addNode(TNode root, int val) {
		if (root == null) {
			return new TNode(val);
		}
		if (root.val < val) {
			root.right = addNode(root.right, val);
		} else {
			root.left = addNode(root.left, val);
		}
		return root;
	}

//left View of binary tree
	public static List<Integer> leftView(TNode root) {
		List<Integer> ans = new ArrayList<Integer>();
		Queue<TNode> queue = new LinkedList<TNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			ans.add(queue.peek().val);
			while (size-- > 0) {
				TNode node = queue.poll();
				if (node.right != null)
					queue.add(node.right);
				if (node.left != null)
					queue.add(node.left);
			}
		}
		return ans;
	}

// Calculate size of tree
	public static int calcSize(TNode node) {
		if (node == null) {
			return 0;
		}
		int left = calcSize(node.left);
		int right = calcSize(node.right);
		return left + right + 1;
	}

//maxElement in tree
	public static int findMaxEle(TNode node) {
		if (node == null) {
			return 0;
		}
		int leftMax = findMaxEle(node.left);
		int rightMax = findMaxEle(node.right);
		if (node.val > leftMax && node.val > rightMax) {
			return node.val;
		} else if (leftMax > rightMax) {
			return leftMax;
		} else {
			return rightMax;
		}
	}

	public static int findHeight(TNode root) {
		if (root == null) {
			return 0;
		}
		int leftht = findHeight(root.left);
		int rightht = findHeight(root.right);
		return Math.max(leftht, rightht) + 1;
	}

	public static int countPairs(TNode node, int distance) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			return 1;
		}
		int l = countPairs(node.left, distance) + 1;
		int r = countPairs(node.right, distance) + 1;
		if (l + r <= distance) {
			c++;
		}
		return Math.min(l, r);
	}

	// Find LCA the lowest comman ancestor
	public static TNode lca(TNode node, int a, int b) {
		if (node == null) {
			return null;
		}
		if (node.val == a) {
			return node;
		}
		if (node.val == b) {
			return node;
		}
		TNode left = lca(node.left, a, b);
		TNode right = lca(node.right, a, b);
		if (left != null && right != null) {
			return node;
		}
		return left != null ? left : right;
	}

//find minimum distance between two nodes in a tree
	public static int distanceBtwNode(TNode node, int a, int b) {
		TNode cnode = lca(node, a, b);
		int d1 = findLevel(cnode, a, 0);
		int d2 = findLevel(cnode, b, 0);
		return d1 + d2;
	}

	public static int findLevel(TNode node, int a, int level) {
		if (node == null) {
			return -1;
		}

		if (node.val == a)
			return level;
		int left = findLevel(node.left, a, level + 1);
		if (left == -1)
			return findLevel(node.right, a, level + 1);
		return left;
	}

	// level order traversal
	public static void hello(TNode root) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		Queue<TNode> helper = new LinkedList<TNode>();
		helper.add(root);
		while (!helper.isEmpty()) {
			int calcSize = helper.size();
			List<Integer> sans = new ArrayList<Integer>();
			for (int i = 0; i < calcSize; i++) {
				TNode node = helper.poll();
				sans.add(node.val);
				if (node.left != null) {
					helper.add(node.left);
				}
				if (node.right != null) {
					helper.add(node.right);
				}
			}
			ans.add(sans);
		}
		System.out.println(ans);
	}

	// zig-zag traversal
	public static void zigzag(TNode root) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		List<Integer> sans = new ArrayList<Integer>();
		Stack<TNode> main = new Stack<TNode>();
		Stack<TNode> helper = new Stack<TNode>();
		main.push(root);
		int level = 0;
		while (!main.isEmpty()) {
			TNode nn = main.pop();
			sans.add(nn.val);
			if (level % 2 == 0) {
				if (nn.left != null)
					helper.push(nn.left);
				if (nn.right != null)
					helper.push(nn.right);
			} else {
				if (nn.right != null)
					helper.push(nn.right);
				if (nn.left != null)
					helper.push(nn.left);
			}
			if (!helper.isEmpty() && main.isEmpty()) {
				main = helper;
				helper = new Stack<TNode>();
				sans = new ArrayList<Integer>();
				ans.add(sans);
				level++;
			}
		}
	}

//	isBalanced
	public static boolean isBalanced(TNode root) {
		int ht = isBalancedCheck(root);
		if (ht != -1)
			return true;
		return false;
	}

	public static int isBalancedCheck(TNode root) {
		if (root == null)
			return 0;
		int lh = isBalancedCheck(root.left);
		if (lh == -1)
			return -1;
		int rh = isBalancedCheck(root.right);
		if (rh == -1)
			return -1;
		if (Math.abs(lh - rh) > 1) {
			return -1;
		}
		return Math.max(lh, rh) + 1;
	}
//	Diameter
//    int max = 0;
//    
//    public int diameterOfBinaryTree(TreeNode root) {
//        maxDepth(root);
//        return max;
//    }
//    
//    private int maxDepth(TreeNode root) {
//        if (root == null) return 0;
//        
//        int left = maxDepth(root.left);
//        int right = maxDepth(root.right);
//        
//        max = Math.max(max, left + right);
//        
//        return Math.max(left, right) + 1;
//    }

	// Returns count of nodes in BST in
	// range [low, high]
//    int getCount(Node node, int low, int high)
//    {
//        // Base Case
//        if(node == null)
//            return 0;
// 
//        // If current node is in range, then
//        // include it in count and recur for
//        // left and right children of it
//        if(node.data >= low && node.data <= high)
//            return 1 + this.getCount(node.left, low, high)+
//                this.getCount(node.right, low, high);
//                 
//        // If current node is smaller than low,
//        // then recur for right child
//        else if(node.data < low)
//            return this.getCount(node.right, low, high);
//         
//        // Else recur for left child
//        else
//            return this.getCount(node.left, low, high);    
//    }

}
