package Greedy;

public class SumWithMultiplicity923 {
	public static void main(String[] args) {
System.out.println(5.e);
	}

	public static int threeSumMulti(int[] arr, int target, int i, int sum, int len) {
		if (i >= arr.length || len > 3) {
			return 0;
		}
		if (sum == target) {
			return 1;
		}
		return threeSumMulti(arr, target, i + 1, sum + arr[i], len + 1) + threeSumMulti(arr, target, i + 1, sum, len);

	}
}
