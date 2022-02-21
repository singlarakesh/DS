package slidingWindow;

public class MaxSumSubarray {
	public static void main(String[] args) {
		int ar[] = { 100, 200, 300, 400 };
		int k = 2;
		findMaxSumOfK(ar, k);
	}

	private static void findMaxSumOfK(int[] ar, int k) {
		int i = 0;
		int j = 0;
		int sum = 0;
		int maxSum=0;
		while (j < ar.length) {
			sum += ar[j];
			if (j - i + 1 == k) {
				if(sum>maxSum) {
					maxSum=sum;
				}
				sum=sum-ar[i];
				i++;
				j++;
			} else {
				j++;
			}
		}
		System.out.println(maxSum);
	}
}
