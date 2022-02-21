package HacherBlocks;

import java.util.*	;

//8 8
//2 3 7 10 12 15 30 34
//1 5 7 8 10 15 16 19
//122
public class AMaximumPath {
	static Scanner scr = new Scanner(System.in);

	public static void main(String args[]) {
		int n = scr.nextInt();
		for (int i = 0; i < n; i++) {
			int n1 = scr.nextInt();
			int n2 = scr.nextInt();
			int[] array = takeInput(n1);
			int[] array2 = takeInput(n2);
			int k = first(array, array2);
			System.out.println(k);
		}

	}

	public static int[] takeInput(int n) {

		int array[] = new int[n];
		for (int i = 0; i < array.length; i++) {
			array[i] = scr.nextInt();
		}

		return array;
	}

	public static int first(int a[], int b[]) {
		int i = 0;
		int j = 0;

		int sum1 = 0, sum2 = 0, sumans = 0;
		while (i < a.length && j < b.length) {

			if (a[i] > b[j]) {
				sum2 += b[j++];

			} else if (b[j] > a[i]) {
				sum1 += a[i++];

			} else {
				sumans += (sum1 > sum2) ? sum1 : sum2;
				sum1 = 0;
				sum2 = 0;

				while (i < a.length && j < b.length && a[i] == b[j]) {
					sumans += a[i++];
					j++;
				}

			}

		}
		while (i == a.length && j < b.length) {
			sum2 += b[j++];
		}
		while (j == b.length && i < a.length) {
			sum1 += a[i++];

		}

		int sum = sum1 > sum2 ? sum1 : sum2;
		return sum + sumans;
	}
}
