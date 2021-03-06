package LeetCode;

import java.util.Arrays;

public class Most_Profit_Assigning_Work_826 {
	public static void main(String[] args) {
		int[] difficulty= {2,4,6,8,10};
		int[] profit= {10,20,30,40,50};
		int[] worker={4,5,6,7};
		System.out.println(maxProfitAssignment(difficulty,profit,worker));
	}

	public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
		Arrays.sort(worker);
        int maxprofit=0;
		for (int i = 0; i < worker.length; i++) {
			int l = 0;
			int r = difficulty.length;
			int prof=0;
			while (l <= r) {
 				int mid = l + (r - l)/ 2;
				if(difficulty[mid]==worker[i]) {
					prof=profit[mid];
					r=mid-1;
				}else if(difficulty[mid]<worker[i]) {
					prof=prof<profit[mid]?profit[mid]:prof;
					l=mid+1;
				}else {
					r=mid-1;
				}
			}
			maxprofit+=prof;
		}
		return maxprofit;
	}
}
