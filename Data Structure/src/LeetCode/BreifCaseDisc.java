package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class BreifCaseDisc {
	public static void main(String[] args) {
		int n = 4;
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();
		swiggyDisc(1, n, l1, l2);
	}

	private static void swiggyDisc(int i, int n, List<Integer> l1, List<Integer> l2) {
		// TODO Auto-generated method stub
		if (i > n) {
			System.out.println(l1);
			System.out.println(l2);
			return;
		}
//		if (l1.size() < n / 2) {
//			swiggyDisc(i+1, n, l1, l2);
//			l1.add(i);
//			swiggyDisc(i+1, n, l1, l2);
//		}
//		if (l2.size() < n / 2) {
		     l1.add(i);
		   swiggyDisc(i+1, n, l1, l2);
			l2.add(i);
			swiggyDisc(i+1, n, l1, l2);
//		}
	}
}
