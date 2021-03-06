package String;

import java.util.Scanner;

public class AddToBinary {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		String a = scr.nextLine();
		String b = scr.nextLine();
		StringBuilder ans = new StringBuilder();
		int i = a.length() - 1;
		int j = b.length() - 1;
		int sum = 0, carry = 0;
		while (i >= 0 || j >= 0) {
			sum = carry;
			if (i >= 0)
				sum += a.charAt(i--) - '0';
			if (j >= 0)
				sum += b.charAt(j--) - '0';
			ans.append(sum % 2);
			carry = sum / 2;
		}
		if (carry != 0)
			ans.append(carry);

		ans = ans.reverse();
		System.out.println(ans);

	}
}
