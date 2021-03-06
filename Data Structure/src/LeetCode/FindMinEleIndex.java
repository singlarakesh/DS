package LeetCode;

public class FindMinEleIndex {
	public static void main(String[] args) {
		int nums[] = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 0;
		int lind = findMinIndex(nums);
//		if(nums[lind]==target)
//			return lind;
		int ind = binarySearch(nums, 0, lind,target);
		int ind1 = binarySearch(nums, lind+1, nums.length-1,target);
		
	}

	private static int binarySearch(int[] nums, int lb, int ub,int target) {
		// TODO Auto-generated method stub
		while (lb <= ub) {
			int mid = lb + (ub - lb) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				ub = mid - 1;
			} else {
				lb = mid + 1;
			}
		}
		return -1;
	}

	private static int findMinIndex(int[] a) {
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
