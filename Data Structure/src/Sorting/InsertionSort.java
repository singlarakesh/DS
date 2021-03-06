package Sorting;

public class InsertionSort {
	public static void main(String[] args) {
		int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
		insertionSort(arr, arr.length);
		for (int i : arr)
			System.out.println(i);
	}

	private static void insertionSort(int[] a, int n) {
		// TODO Auto-generated method stub
		for (int i = 1; i < n; i++) {
			int temp = a[i];
			int j = i - 1;
			while (j >= 0 && a[j]>temp) {
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=temp;
		}
	}
}
