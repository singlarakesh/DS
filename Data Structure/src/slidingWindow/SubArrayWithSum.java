package slidingWindow;

public class SubArrayWithSum {
	public static void main(String[] args) {
		int ar[] = { 1, 4, 20, 3, 10, 5 };
		int sum = 33;
		findSubArray(ar, sum);
	}

	private static void findSubArray(int[] ar, int sum) {
		// TODO Auto-generated method stub
		int total = 0;
		int i = 0;
		int j = 0;
		while (j < ar.length) {

			if (total == sum) {
				System.out.println(i + " " + j);
				j++;
			} else if (total > sum) {
				total -= ar[i];
				i++;
			} else {
				total += ar[j];
				j++;
			}
		}
	}
}
