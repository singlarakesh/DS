package Array;

public class SearchInRotatedSortedArray {
	public static void main(String[] args) {
		int ar[] = { 5, 4, 3, 2, 1 };
		searchEle(ar, 1);
	}

	private static void searchEle(int[] ar, int element) {
		// TODO Auto-generated method stub
		int pivotIndex = findPivot(ar);
		System.out.println(pivotIndex);
	}

	private static int findPivot(int[] ar) {
		// TODO Auto-generated method stub

		int lb = 0;
		int ub = ar.length;
		while (lb < ub) {
			int mid = (lb + ub) / 2;
			if (ar[mid] < ar[mid - 1]) {
				return mid;
			} else if (ar[mid] > ar[lb]) {
				lb = mid;
			} else {
				ub = mid;
			}
		}

		return 0;
	}
}
