package LeetCode;

public class MinInRotatedArray {
	public static void main(String[] args) {
		int nums[] = {11};
		int lind = findMinIndex(nums);
		System.out.println(nums[lind]);
	}

	private static int findMinIndex(int[] a) {
		// TODO Auto-generated method stub
		if(a.length==1)
			return 0;
		int lb=0;
		int ub=a.length-1;
		while(lb<=ub) {
			int mid=(lb+ub)/2;
			int left=(mid+a.length-1)%a.length;
			int right=(mid+1)%a.length;
			if(a[left]>a[mid]) {
				return mid;
			}else if(a[right]<a[mid]) {
				return right;
			}else if(a[lb]<= a[mid]){	
				lb=mid+1;	
			}else {	
				ub=mid-1;
			}
		}
		return lb;
	}
}
