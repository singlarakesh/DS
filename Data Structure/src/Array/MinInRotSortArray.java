package Array;

public class MinInRotSortArray {
	public static void main(String[] args) {
		int arr6[] = { 5, 1 };
		int n6 = arr6.length;
		System.out.println("The minimum element is " + findMin(arr6, 0, n6 - 1));
	}

	private static int findMin(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		while (start < end) {
			int mid = (start + end) / 2;
			if(arr[mid]<arr[mid+1] && arr[mid]<arr[mid-1]) {
				return arr[mid];
			}else if(arr[mid]<arr[mid+1] && arr[mid]>arr[mid-1]) {
				end=mid;
			}else if(arr[mid]>arr[mid+1] && arr[mid]<arr[mid-1]) {
				start=mid;
			}
		}
		return 0;
	}
}
