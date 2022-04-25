package Greedy;

public class KProductSubset {
	public static void main(String[] args) {
		int arr[] = { 2, 4, 5, 3 };
		int k = 12;
		findProductSet(arr, k, 0, 1);
	}

	private static void findProductSet(int[] arr, int k, int i, int p) {
		// TODO Auto-generated method stub
		if (i >= arr.length || p > k)
			return;
		if (k > p && p != 1) { 
			System.out.print(p + " ");
		}
		findProductSet(arr, k, i + 1, p * arr[i]);
		findProductSet(arr, k, i + 1, p);
	}
}
