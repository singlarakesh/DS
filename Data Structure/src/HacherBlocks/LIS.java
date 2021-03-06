package HacherBlocks;

import java.util.Scanner;
import java.util.Stack;

//Longest Increasing Subsequence
public class LIS {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scr.nextInt();
		}
		increasingSubs(a);
	}

	private static void increasingSubs(int[] a) {
		// TODO Auto-generated method stub
		int dp[]=new int[a.length+1];
		dp[0]=1;
		dp[1]=1;
		for(int i=2;i<=a.length;i++) {
			int max=0;
			for(int j=1;j<i;j++) {
				if(a[j-1]<a[i-1]) {
					max=Math.max(max, dp[j]);
				}			
			}
			dp[i]=max+1;
		}
		int max=Integer.MIN_VALUE;
		for(int i=0;i<dp.length;i++) {
			if(max<dp[i]) {
				max=dp[i];
			}
		}
		System.out.println(max);
	}

//	private static int increasingSubs(int[] a, Stack<Integer> s, int i) {
//		if (i >= a.length) {
//			return s.size();
//		}
//		int s1 = 0;
//		int s2 = 0;
//		if (!s.isEmpty()) {
//			if (s.peek() < a[i]) {
//				s.push(a[i]);
//				s1 = increasingSubs(a, s, i++);
//			} else {
//				s2 = increasingSubs(a, s, i++);
//			}
//		} else {
//			s2 = increasingSubs(a, s, i++);
//			s.push(a[i]);
//			s1 = increasingSubs(a, s, i++);
//		}
//		return Math.max(s1, s2);
//	}
}
