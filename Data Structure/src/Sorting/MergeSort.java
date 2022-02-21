package Sorting;

public class MergeSort {
	public static void main(String[] args) {
		int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
		mergeSort(arr, 0, arr.length);
		for (int i : arr)
			System.out.println(i);
	}

	private static void mergeSort(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		if (i < j) {
			int mid = i + (j - i) / 2;
			mergeSort(arr, i, mid);
			mergeSort(arr, mid + 1, j);
			mergeArray(arr, i, mid, j);
		}
	}

	private static void mergeArray(int[] arr, int i, int mid, int j) {
		int b[] = new int[arr.length];
		int l = i;
		int m = mid;
		int k = i;
		while (l < mid && m <= j) {
			if (arr[l] < arr[m]) {
				b[k] = arr[l];
				l++;
			} else {
				b[k] = arr[m];
				m++;
			}
			k++;
		}
		while (l < mid) {
			b[k] = arr[l];
			l++;
			k++;
		}
		while (m <= j) {
			b[k] = arr[m];
			m++;
			k++;
		}
		for (int it = i; it <= j; it++)
			arr[it] = b[it];
	}
}
