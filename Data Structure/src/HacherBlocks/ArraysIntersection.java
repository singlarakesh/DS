package HacherBlocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArraysIntersection {
	public static void main(String[] args) {
       Scanner scr=new Scanner(System.in);
       int n=scr.nextInt();
       int a[]=new int[n];
       int b[]=new int[n];
       for(int i=0;i<n;i++) {
    	   a[i]=scr.nextInt();
    	   b[i]=scr.nextInt();
       }
       Arrays.sort(a);
       Arrays.sort(b);
       ArrayList<Integer> arr=new ArrayList<Integer>();
       for(int i=0,j=0;i<a.length&&j<b.length;) {
    	   if(a[i]==b[j]) {
    		   arr.add(a[i]);
    		  i++;
    		  j++; 		  
    	   }else if(a[i]<b[j]) {
    		   i++;
    	   }else {
    		   j++;
    	   }
    	   
       }
       System.out.println(arr);
	}
}
