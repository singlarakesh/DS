
public class BitWise {
	public static void main(String[] args) {
		int ar[] = new int[] { 2, 3, 2,2};
		int n = ar.length;
		System.out.println(getOddOccurrence(ar, n));
	}

	private static int getOddOccurrence(int[] ar, int n) {
		// TODO Auto-generated method stub
		int i;
		int res = 0;
		for (i = 0; i < ar.length; i++) {		
			res = res ^ ar[i];
			System.out.println(res);
		}

		return res;
	}
}
