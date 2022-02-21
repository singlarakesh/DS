import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int ar[] = new int[n];
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < ar.length; i++) {
			ar[i] = scr.nextInt();
		}
		nextGreater(ar, n, s);
	}

	private static void nextGreater(int[] ar, int n, Stack<Integer> s) {
		for (int i = ar.length-1; i >=0; i++) {
			if (s.isEmpty()) {
				s.push(ar[i]);
			} else {
				while (!s.isEmpty() && ar[i] < s.peek()) {
					System.out.println(ar[i] + "<--" + s.pop());
				}
				s.push(ar[i]);

			}
		}
		while (!s.isEmpty()) {
			System.out.println(s.pop() + "-->-1");
		}
	}

}
