package String;

import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i]=scr.nextInt();
		}
		findNextGreater(a);
	}

	private static void findNextGreater(int[] a) {
		// TODO Auto-generated method stub
		Stack<Integer> s=new Stack<Integer>();
		int ng[]=new int[a.length];
		ng[a.length-1]=-1;
		s.push(a[a.length-1]);
		for(int i=a.length-2;i>=0;i--) {
           while(!s.isEmpty()&& a[i]>s.peek()) {
        	   s.pop();
           }
           if(s.isEmpty()) {
        	   ng[i]=-1;
           }else {
        	   ng[i]=s.peek();
           }
           s.push(a[i]);	
		}
	}
}
