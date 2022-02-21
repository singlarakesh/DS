package HacherBlocks;

import java.util.Scanner;

public class Aspiral {
		public static void main(String[] args) {
			Scanner scr = new Scanner(System.in);
			int m = scr.nextInt();
			int n = scr.nextInt();
			int a[][] = new int[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					a[i][j] = scr.nextInt();
				}
			}
			int i, k = 0, l = 0;
			while (k < m && l < n) {
				for (i = k; i < m; i++) {
					System.out.print(a[i][l] + ", ");
				}
				l++;
				for (i = l; i < n; ++i) {
					System.out.print(a[m - 1][i] + ", ");
				}
				m--;
				for (i = m-1; i >= k; --i)
	            {
	                System.out.print(a[i][n-1]+", ");
	            }
	            n--;  
	            for (i = n-1; i >= l; --i)
	            {
	                System.out.print(a[k][i]+", ");
	            }
	            k++;
			}
		    System.out.print("END");
		}
}
