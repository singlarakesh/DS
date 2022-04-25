import java.util.HashSet;

public class Test1 {
	public static void main(String[] args) {
//		String str = "aaaabbcdabh";
//		maxLenSubString(str);
		int num = 121;
		System.out.println(isHappyNumber(num));
		;
	}

	private static boolean isHappyNumber(int num) {
		if (num == 1)
			return true;

		int newNum = 0;
		while (num != 0) {
			int temp = num % 10;
			num = num / 10;
			newNum += temp * temp;
		}

		return isHappyNumber(newNum);

	}

	private static void maxLenSubString(String str) {
		HashSet<Character> set = new HashSet<>();
		int i = 0;
		int j = 0;
		int maxLen = 0;
		while (j < str.length()) {
			char ch = str.charAt(j);
			if (set.add(ch)) {
				j++;
			} else {
				maxLen = Math.max(maxLen, j - i);
				while (i <= j && !set.add(ch)) {
					set.remove(str.charAt(i));
					i++;
				}
				j++;
			}
		}
		maxLen = Math.max(maxLen, j - i);
		System.out.println(maxLen);

	}
}
