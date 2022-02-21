//https://www.javatpoint.com/quick-sort
public class QuickSort {
	public static void main(String[] args) {
		int a[] = { 6,5,4,3,2,1};
		QuickSort(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	private static void QuickSort(int[] a, int start, int end) {
		// TODO Auto-generated method stub
		if (start < end) {
			int pivot = findPivot(a, start, end);
			QuickSort(a, start, pivot - 1);
			QuickSort(a, pivot + 1, end);
		}
	}

	private static int findPivot(int[] a, int low, int high) {
		// TODO Auto-generated method stub
		int mid = (low + high) / 2;
		int pivot = a[mid];
		int i = low;
		int j = high;
		while (i < j) {
			while (i < high && a[i] <= pivot) {
				i++;
			}
			while (j >= 0 && a[j] > pivot) {
				j--;
			}
			if (i < j) {
				swap(a, i, j);
			}
		}
		swap(a, j, mid);
		return j;
	}

	private static void swap(int[] a, int i, int j) {
		// TODO Auto-generated method stub
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
