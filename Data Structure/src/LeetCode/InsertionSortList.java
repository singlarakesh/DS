package LeetCode;

public class InsertionSortList {
	public static void main(String[] args) {
		int ar[] = { 4, 2, 1, 3 };
		insertSort(ar);
		for (int a : ar) {
			System.out.println(a);
		}
	}

	private static void insertSort(int[] a) {
		// TODO Auto-generated method stub

		for (int i = 1; i < a.length; i++) {
			int temp = a[i];
			int j = i - 1;
			while (j >= 0 && a[j] > temp) {
				a[j + 1] = a[j];
				j--;
			}
			a[j+1] = temp;
		}
	}
}
