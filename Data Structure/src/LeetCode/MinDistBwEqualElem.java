package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

public class MinDistBwEqualElem {
	public static void main(String[] args) {
		int ar[] = {3, 5, 4, 6,  3,5} ;
		findMin(ar);
	}

	private static void findMin(int[] ar) {
		// TODO Auto-generated method stub
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		for (int i = 0; i < ar.length; i++) {
			int item=ar[i];
			if(map.containsKey(item)) {
				ArrayList<Integer> list=  map.get(item);
				if(list.size()==1) {
					list.add(i);
					map.put(item, list);
				}
			}else {
				ArrayList<Integer> list=new ArrayList<Integer>();
				list.add(i);
				map.put(item, list);
			}
		}
     int min=Integer.MAX_VALUE;
     for(int item:map.keySet()) {
    	 ArrayList<Integer> list=  map.get(item);
    	 if(list.size()==2) {
    		 int si=list.get(0);
    		 int ei=list.get(1);
    		 min=(ei-si<min)?ei-si:min;
    	 }
     }
     System.out.println(min);
	}
}
