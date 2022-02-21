import java.util.Scanner;

public class FlipString_Monotonus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scr = new Scanner(System.in);
		String str = scr.next();
		minFlipsRequired(str);
	}

	private static void minFlipsRequired(String str) {
		// TODO Auto-generated method stub
		int i = 0;
		int minFlips = 0;
		int countOfOne = 0;
		int flipableZeros = 0;
		while (i <= str.length() - 1) {
			char item = str.charAt(i);
			if (item == '0') {
				if (countOfOne == 0) {
					// Do Nothing
				} else {
					flipableZeros++;
				}
			} else {
				countOfOne++;
			}
			if (countOfOne < flipableZeros)
				flipableZeros = countOfOne;
			i++;
		}
		System.out.println(flipableZeros);
	}

}
