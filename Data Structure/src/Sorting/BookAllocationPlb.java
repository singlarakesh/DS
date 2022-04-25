package Sorting;

public class BookAllocationPlb {
	public static void main(String[] args) {
		int pages[] = { 12, 34, 67, 90 };
		int m = 2;
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int page : pages) {
			sum += page;
			max = Math.max(max, page);
		}
		int lb = max;
		int ub = sum;
		while (lb < ub) {
			int mid = (lb + ub) / 2;
			if (checkMax(pages, mid, m)) {

			} else {
			}
		}

	}

	private static boolean checkMax(int[] pages, int mid, int m) {
		// TODO Auto-generated method stub
		int pageRead = 0;
		for (int i = 0; i < pages.length; i++) {
			pageRead += pages[i];
			if(pageRead>mid) {
				pageRead=0;
				m--;
				if(m==0 && i<pages.length) {
					return false;
				}
			}
		}
		return false;
	}
}
