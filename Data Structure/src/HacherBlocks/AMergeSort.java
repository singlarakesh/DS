package HacherBlocks;

public class AMergeSort {
	static int c = 0;

	public static void main(String[] args) {
		int arr[] = {38, 27, 43, 3, 9, 82, 10};
//		sort(arr, 0, arr.length - 1);
		mergeSort(arr, 0, arr.length - 1);
		for(int i:arr) {
			System.out.println(i);
		}
//		System.out.println(c);
	}

	private static void mergeSort(int[] a, int l, int r) {
		// TODO Auto-generated method stub
		if (l < r) {
			int mid = (l + r) / 2;
			mergeSort(a, l, mid);
			mergeSort(a, mid + 1, r);
			merge(a, l, mid, r);
		}
	}

	private static void merge(int[] a, int l, int mid, int r) {
		// TODO Auto-generated method stub
		int i = l;
		int j = mid + 1;
		int k = l;
		int b[] = new int[a.length];
		while (i <= mid && j <= r) {
            if(a[i]<a[j]) {
            	b[k]=a[i];
            	i++;
            }else {
            	b[k]=a[j];
            	j++;
            }
            k++;
		}
		while(i<=mid) {
        	b[k]=a[i];
        	i++;
        	k++;
		}
		while(j<=r) {
        	b[k]=a[j];
        	j++;
        	k++;
		}
		for(int t=l;t<=r;t++) {
			a[t]=b[t];
		}

	}

//	private static void sort(int[] arr, int i, int j) {
//		if (i < j) {
//			int mid = (i + (j-1)) / 2;
//			sort(arr, i, mid);
//			sort(arr, mid + 1, j);
//			merge(arr, i, mid, j);
//		}
//	}
//
//	private static void merge(int[] arr, int l, int m, int r) {
//		// TODO Auto-generated method stub
//		int n1 = m - l + 1;
//		int n2 = r - m;
//		int L[] = new int[n1];
//		int R[] = new int[n2];
//		/* Copy data to temp arrays */
//		for (int i = 0; i < n1; ++i)
//			L[i] = arr[l + i];
//		for (int j = 0; j < n2; ++j)
//			R[j] = arr[m + 1 + j];
//		int i = 0, j = 0;
//		int k = l;
//		while (i < n1 && j < n2) {
//			if (L[i] < R[j]) {
//				arr[k] = L[i];
//				i++;
//				k++;
//			} else {
//				arr[k] = R[j];
//				j++;
//				k++;
//				c+= (m + 1) - (l + i);
//			}
//		}
//		while (i < n1) {
//			arr[k] = L[i];
//			i++;
//			k++;
//		}
//		while (j < n2) {
//			arr[k] = R[j];
//			j++;
//			k++;
//		}
//	}
}
