import java.util.Scanner;

public class BubbleSort {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int ar[] = new int[n];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = scr.nextInt();
		}
		bubbleSort(ar, n);
	}

	private static void bubbleSort(int[] ar, int n) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n - 1; i++) {
			boolean swapped = false;
			for (int j = 0; j < n - i - 1; j++) {
				if (ar[j] > ar[j + 1]) {
					swap(ar, j, j + 1);
					swapped = true;
				}
			}
			if (swapped)
				break;
		}
		for (int i = 0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}
	}

	public static void swap(int ar[], int i, int j) {
		if (ar[i] == ar[j]) {
			return;
		}
		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
	}
}
