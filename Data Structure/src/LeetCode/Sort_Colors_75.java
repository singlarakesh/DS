package LeetCode;

public class Sort_Colors_75 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 2, 0, 2, 1, 1, 0 };

		int i = 0;
		int j = 0;
		int k = a.length - 1;
		while (i <= k) {
			if (a[i] == 0) {
				swap(a, a[i], a[j]);
				i++;
				j++;
			} else if (a[i] == 1) {
				i++;
			} else {
				swap(a, i, k);
				k--;
			}
		}
		for(int l :a) {
			System.out.print(l);
		}
	}

	private static void swap(int[] a, int i, int j) {
		// TODO Auto-generated method stub
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
