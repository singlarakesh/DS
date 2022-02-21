package Amazon;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Stack;

class Interval {
	int start, end;

	@Override
	public String toString() {
		return "Interval [start=" + start + ", end=" + end + "]";
	}

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class MergeIntervals {
	public static void main(String[] args) {
//		Interval ar[] = new Interval[4];
//		ar[0] = new Interval(1, 3);
//		ar[1] = new Interval(2, 6);
//		ar[2] = new Interval(8, 10);
//		ar[3] = new Interval(15, 18);
//		MergeIntervals(ar);
		int[][] a = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		int ar[][]=merge(a);
		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i][0]);
			System.out.print(ar[i][1]);
			System.out.println();
		}
	}

	public static int[][] merge(int[][] ar) {
		Arrays.sort(ar, (a, b) -> a[0] - b[0]);
		Stack<int[]> s = new Stack<>();
		s.push(ar[0]);
		for (int i = 1; i < ar.length; i++) {
			int top[] = s.peek();
			if (top[1] < ar[i][0]) {
				s.push(ar[i]);
			} else if (top[1] < ar[i][1]) {
				top[1] = ar[i][1];
				s.pop();
				s.add(top);
			}
		}
		 LinkedList<int[]> res = new LinkedList<>();
		while (!s.isEmpty()) {
			res.addFirst(s.pop());
		}
		return res.toArray(new int[res.size()][]);
	}

	private static void MergeIntervals(Interval[] ar) {
		// TODO Auto-generated method stub
		Comparator<Interval> compare = (a, b) -> a.start - b.start;
		Arrays.sort(ar, compare);
		Stack<Interval> s = new Stack<>();
		s.push(ar[0]);
		for (int i = 1; i < ar.length; i++) {
			Interval top = s.peek();
			if (top.end < ar[i].start) {
				s.push(ar[i]);
			} else if (top.end < ar[i].end) {
				top.end = ar[i].end;
				s.pop();
				s.add(top);
			}
		}
		System.out.print("The Merged Intervals are: ");
		while (!s.isEmpty()) {
			Interval t = s.pop();
			System.out.print("[" + t.start + "," + t.end + "] ");
		}
	}
}
