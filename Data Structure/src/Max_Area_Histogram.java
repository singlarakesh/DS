import java.util.Stack;

public class Max_Area_Histogram {
	public static void main(String[] args) {
		int hist[] = { 1,1 };
		getMaxArea(hist, hist.length);
	}

	private static void getMaxArea(int[] hist, int length) {
		// TODO Auto-generated method stub
		Stack<Integer> s = new Stack<>();
		int sr[] = new int[length];
		int sl[] = new int[length];
		int res = 0;
		for (int i = length - 1; i >= 0; i--) {
			while (!s.isEmpty() && hist[s.peek()] > hist[i]) {
				s.pop();
			}
			if (s.isEmpty()) {
				sr[i] = length;
			} else {
				sr[i] = s.peek();
			}
			s.push(i);
		}
		s = new Stack<>();
		for (int i = 0; i < length; i++) {
			while (!s.isEmpty() && hist[s.peek()] > hist[i]) {
				s.pop();
			}
			if (s.isEmpty()) {
				sl[i] = -1;
			} else {
				sl[i] = s.peek();
			}
			s.push(i);
		}
		for(int i:sr) {
			System.out.println(i);
		}
		for (int i = 0; i < length; i++) {
			int v = sr[i] - sl[i] - 1;
			int val = v * hist[i];
//			System.out.println(v * hist[i]);
			res = res > val ? res : val;
		}
	}
}
