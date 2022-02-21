package LeetCode;

public class SearchInRotatedArray {
	public static void main(String[] args) {
		int a[] = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 0;
		int ans = -1;
		int i = 0;
		int j = a.length - 1;
		while (i <= j) {
			int mid = (i + j) / 2;
			if (a[mid] == target) {
                 ans=mid;
                 break;
			} else if (a[mid] > target) {
				if(target<a[j]) {
					i=mid+1;
				}else {
					j=mid-1;
				}
			} else {
				if(target<a[j]) {
					i=mid+1;
				}else {
					j=mid-1;
				}
			}
		}
		System.out.println(ans);
	}
}
