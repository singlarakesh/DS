package Sorting;

public class BubbleSort {
	public static void main(String[] args) {
		 int arr[] = {64, 34, 25, 12, 22, 11, 90};
		 bubbleSort(arr,arr.length);
		 for(int i:arr)
			 System.out.println(i); 
	}

	private static void bubbleSort(int[] a, int n) {
		// TODO Auto-generated method stub
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<n-i-1;j++) {
				if(a[j]>a[j+1]) {
					int temp=a[j+1];
					a[j+1]=a[j];
					a[j]=temp;
				}
			}
		}
	}
}
