package dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test {
	public static void main(String[] args) {
		int ar[] = { 8, 1, 1, 1, 2, 8, 5 };
		int k = 5;
//		System.out.println(largestSubArray(ar, k));
//		System.out.println(longestSubstringWithoutRepeating("pwwkesw"));
		System.out.println(avoidFlood(ar));
	}

	public static int[] avoidFlood(int[] rains) {
		HashMap<Integer, Integer> map = new HashMap<>();
		TreeSet<Integer> set = new TreeSet<>();
		int ans[] = new int[rains.length];
		for (int i = 0; i < rains.length; i++) {
			if (rains[i] == 0) {
				set.add(i);
			} else {
				if (map.containsKey(rains[i])) {
					Integer zero = set.ceiling(map.get(rains[i]));
					if (zero == null) {
						int emp[] = {};
						return emp;
					}
					set.remove(zero);
				}
				ans[i] = -1;
				map.put(rains[i], i);
			}
		}
		return ans;
	}

//	 public static int[] avoidFlood(int[] rains) {
//	       HashMap<Integer,Integer> map=new HashMap<>();
//	        int ans[]=new int[rains.length];
//	        for(int i=0;i<rains.length;i++){
//	            if(rains[i]==0){
//	                int val=getElementAfterZero(rains,i,map);
//	                System.out.println(val);
//	                
//	                ans[i]=val;
//	                if(map.containsKey(val)){
//	                map.remove(val);
//	                }
//	            }else{
//	                if(map.containsKey(rains[i])){
//	                int emp[]={};
//	                    return emp;
//	                }else{
//	                    ans[i]=-1;
//	                    map.put(rains[i], i);
//	                }
//	               
//	            }
//	        }
//	        return ans;
//	    }
	public static int getElementAfterZero(int rains[], int i, HashMap<Integer, Integer> map) {
		for (int j = i + 1; j < rains.length; j++) {
			map.containsKey(rains[j]);
			if (rains[j] != 0 && map.containsKey(rains[j]))
				return rains[j];
		}
		return 1;
	}

	private static int longestSubstringWithoutRepeating(String str) {
		// TODO Auto-generated method stub
		int i = 0, j = 0, sum = 0, max = Integer.MIN_VALUE;
		Set<Character> set = new HashSet<>();
		while (j < str.length()) {
			char ch = str.charAt(j);
			if (set.add(ch)) {
				j++;
			} else {
				max = Math.max(max, set.size());
				while (i <= j && !set.add(ch)) {
					set.remove(str.charAt(i));
					i++;
				}
				j++;
			}
		}
		return max;
	}

	private static int largestSubArray(int[] ar, int k) {
		// TODO Auto-generated method stub
		int i = 0, j = 0, sum = 0, max = Integer.MIN_VALUE;
		while (j < ar.length) {
			sum += ar[j];
			if (sum < k) {
				j++;
			} else if (sum == k) {
				max = Math.max(max, j - i + 1);
				j++;
			} else {
				while (sum > k && i < j) {
					sum -= ar[i];
					i++;
				}
				j++;
			}
		}
		return max;
	}
}
