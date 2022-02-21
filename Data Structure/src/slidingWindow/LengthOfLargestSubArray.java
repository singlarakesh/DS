package slidingWindow;

public class LengthOfLargestSubArray {
	public static void main(String[] args) {
		int[] ar = { -5, 8, -14, 2, 4, 12 };
		int k = -5;
		calMaxSize(ar, k);
	}

	private static void calMaxSize(int[] ar, int k) {
		// TODO Auto-generated method stub
		
	}

//	private static void calMaxSize(int[] ar, int k) {
//		// TODO Auto-generated method stub
//		int i = 0;
//		int j = 0;
//		int maxl = 0;
//		int sum = 0;
//		while (j < ar.length) {
//			sum += ar[j];
//			if (sum == k) {
//				int l=(j-i)+1;
//				if(l>maxl)
//					maxl=l;
//				i++;
//				j=i;
//				sum=0;
//			} else {
//				j++;
//			}
//		}
//		System.out.println(maxl);
//	}
//	private static void calMaxSize(int[] ar, int k) {
//		// TODO Auto-generated method stub
//		int i = 0;
//		int j = 0;
//		int maxl = 0;
//		int sum = 0;
//		while (j < ar.length) {
//			sum += ar[j];
//			if (sum == k) {
//				int l = (j - i) + 1;
//				if (l > maxl)
//					maxl = l;
//			}
//			if (sum > k) {
//				while (sum > k && i < j) {
//					sum -= ar[i];
//					i++;
//				}
//			}
//			j++;
//		}
//		System.out.println(maxl);
//	}
}
