package HacherBlocks;

public class JobForBounties {
	public static void main(String[] args) {
		String str = "(()(()()";
		int i = 0;
		int j = i + 1;
		int max = 0;
		for (; i < str.length() && j < str.length();) {
			if (j - i % 2 == 0) {
				if (str.charAt(j) == '(') {
					j++;
				} else {
					if (j - i != 1)
						max = Integer.max(max, j - i);
					i = j;
					j++;
				}
			} else {
				if (str.charAt(j) == ')') {
					j++;
				} else {
					if (j - i != 1)
						max = Integer.max(max, j - i);
					i = j;
					j++;
				}
			}
		}
		if (str.charAt(j - 1) == ')')
			max = Integer.max(max, j - 1 - i);
		System.out.println(max);
	}
}
