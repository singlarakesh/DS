package dp;

public class SortColor {
	public static void main(String[] args) {
		int a[] = { 2, 0, 2, 1, 1, 0 };
		int i = 0;
		int j = 0;
		int k = a.length - 1;
		while (j <= k) {
			if (a[j] == 0) {
				swap(a, i, j);
				i++;
				j++;
			} else if (a[j] == 2) {
				swap(a, j, k);
				k--;
			} else {
				j++;
			}
		}
		for (int s : a) {
			System.out.println(s);
		}
	}

	private static void swap(int[] a, int j, int k) {
		// TODO Auto-generated method stub
		int temp = a[j];
		a[j] = a[k];
		a[k] = temp;
	}

}
