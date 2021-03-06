package Walmart;

import java.util.HashMap;
import java.util.Map;

// ar---> 7 3 1 2 6 19 8 4   sum=10
//
public class Test {
	public static void main(String[] args) {
		int ar[] = { 7, 3, 1, 2, 6, 19, 8, 4 };
		int target = 10;
		int ans=getSmallestLength(ar, target);
		System.out.println(ans);
	}

	private static int getSmallestLength(int[] ar, int target) {
		// TODO Auto-generated method stub
		HashMap<Integer,Integer> map=new HashMap<>();
		int sans=Integer.MAX_VALUE;
		//store array items index in hashmap
		for(int i=0;i<ar.length;i++) {
			if(map.containsKey(ar[i])) {
				
			}else {
				map.put(ar[i], i);
			}
		}
		for(int i=0;i<ar.length;i++) {
	       int val=target-ar[i];
	       if(map.containsKey(val)) {
	    	  int desIndex=map.get(val);
	    	  int diff=Math.abs(desIndex-i);
	    	  sans=Math.min(sans, diff);
	       }
		}
		return sans;
	}
}
