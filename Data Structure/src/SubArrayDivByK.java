import java.util.Scanner;
import java.util.Stack;

public class SubArrayDivByK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int ar[] = new int[n];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = scr.nextInt();
		}
		int k = scr.nextInt();
		subArrayDivByK(ar, k);
	}

	private static void subArrayDivByK(int[] ar, int k) {
		int res = 0;
		// TODO Auto-generated method stub
		for (int i = 0; i < ar.length; i++) {
			int sum = 0;
			sum += ar[i];
			if (sum % k == 0) {
				res += 1;
			}
			for (int j = i + 1; j < ar.length; j++) {
				sum += ar[j];
				if (sum % k == 0) {
					res += 1;
				}
			}
		}
		System.out.println(res);
	}

}
