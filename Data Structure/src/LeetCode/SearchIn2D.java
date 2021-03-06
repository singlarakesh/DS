package LeetCode;

public class SearchIn2D {
	public static void main(String[] args) {
		int matrix[][] = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		int i=0;
		int j=matrix.length;
		int target=3;
		int ans=-1;
		while(i<=j) {
			int mid=(i+j)/2;
			if(matrix[mid][0]==target) {
				ans=mid;
				break;
			}else if(matrix[mid][0]>target) {
				ans=mid-1;
				j=mid-1;
			}else {
				ans=mid+1;
				i=mid+1;	
			}
		}
		System.out.println(ans);
	}
}
