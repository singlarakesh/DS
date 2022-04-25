package dp;

public class SubsetProductLessThankK {
	public static void main(String[] args) {
		int arr[] = { 2, 4, 5, 3 };
		int k = 12;
		System.out.println(productTotal(arr, k, 1, 0));;
	}

	private static int productTotal(int[] arr, int k, int p, int index) {
		// TODO Auto-generated method stub
		if (index == arr.length && p < k) {
			return 1;
		}
		if (p > k || index >= arr.length)
			return 0;

		return productTotal(arr, k, p * arr[index], index + 1) + productTotal(arr, k, p, index + 1);
	}
}
