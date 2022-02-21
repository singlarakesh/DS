package HacherBlocks;

public class AQuickSort {
	public static void main(String[] args) {
		int arr[] = {38, 27, 43, 3, 9, 82, 10};
		quickSort(arr, 0, arr.length - 1);
		for(int i:arr) {
			System.out.println(i);
		}
	}

	private static void quickSort(int[] arr, int l, int r) {
		// TODO Auto-generated method stub
		if(l<r) {
			int mid=(l+r)/2;
			int piv=findPivot(arr,l,r);
			quickSort(arr, l, piv-1);
			quickSort(arr, piv+1, r);
		}
	}

	private static int findPivot(int[] arr, int l, int r) {
		// TODO Auto-generated method stub
		int mid=(l+r)/2;
		int piv=arr[mid];
		int i=l;
		int j=r;
		while(i<j) {
			while(arr[i]<piv) {
				i++;
			}
			while(arr[j]>piv) {
				j--;
			}
			if(i<j) {
				swap(arr,i,j);
			}
		}
		return j;
	}

	private static void swap(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
	    int temp=arr[i];
	    arr[i]=arr[j];
	    arr[j]=temp;
	}
}
