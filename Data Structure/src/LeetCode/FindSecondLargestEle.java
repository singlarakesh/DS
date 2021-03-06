package LeetCode;

public class FindSecondLargestEle {
	public static void main(String[] args) {
		int arr[] = { 1, 1, 1, 1 };
		findSecondLargest(arr);
	}

	private static void findSecondLargest(int[] arr) {
		// TODO Auto-generated method stub
		int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
		int i = 0;
		while (i < arr.length) {
			if (arr[i] > second && arr[i] != first) {
				if (arr[i] > first) {
					second = first;
					first = arr[i];
				} else {
					second = arr[i];
				}
			}
			i++;
		}
		if (second == Integer.MIN_VALUE)
			System.out.println(-1);
		System.out.println(second);
	}
}
