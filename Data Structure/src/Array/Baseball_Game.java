package Array;

import java.util.Stack;

public class Baseball_Game {
	public static void main(String[] args) {
		String ops[] = { "5", "2", "C", "D", "+" };

		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < ops.length; i++) {
			String ch = ops[i];
			switch (ch) {
			case "C": {
				s.pop();
			}
				break;
			case "D": {
				int doubleValue = s.peek() * s.peek();
				s.push(doubleValue);
			}
				break;
			case "+": {
				int peekValue = s.pop();
				int addValue = peekValue + s.peek();
				s.push(peekValue);
				s.push(addValue);

			}
			default: {
				s.push(Integer.parseInt(ch));
			}
			}
		}
		int ans = 0;
		while (!s.isEmpty()) {
			ans += s.pop();
		}
	}
}
