import java.util.Scanner;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int ar[] = new int[n];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = scr.nextInt();
		}
		insertionSort(ar, n);
	}

	private static void insertionSort(int[] a, int n) {
		// TODO Auto-generated method stub
		for (int i = 1; i < n; i++) {
			int temp = a[i];
			int t = i - 1;
			while (t >= 0 && a[t] > temp) {
				a[t + 1] = a[t];
				t = t - 1;
			}
			a[t + 1] = temp;

		}
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

}
