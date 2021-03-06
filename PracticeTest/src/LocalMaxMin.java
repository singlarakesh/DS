import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LocalMaxMin {
	public static void main(String[] args) {
		int ar[] = { 100, 180, 260, 310, 40, 535, 695 };
		List<Integer> max = new ArrayList<>();
		List<Integer> min = new ArrayList<>();
		boolean maxvalid = false;
		boolean minvalid = false;
		Queue<Integer> q = new LinkedList<Integer>();
		if (ar[0] > ar[1]) {
			max.add(0);
			minvalid = true;
		} else {
			min.add(0);
			maxvalid = true;
		}
		int i = 1;
		while (i < ar.length) {
			if (maxvalid) {
				if (!q.isEmpty() && ar[i] < ar[q.peek()]) {
					max.add(i);
					q = new LinkedList<Integer>();
					maxvalid = false;
					minvalid = true;
				}
				q.add(i);
			}
			if (maxvalid) {
				if (!q.isEmpty() && ar[i] > ar[q.peek()]) {
					min.add(i);
					q = new LinkedList<Integer>();
					maxvalid = true;
					minvalid = false;
				}
				q.add(i);
			}
			i++;
		}
		System.out.println(max);
		System.out.println(min);
	}
}
