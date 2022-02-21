import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
//https://leetcode.com/problems/reorder-data-in-log-files/
//https://leetcode.com/discuss/interview-question/313719/Amazon-or-Online-Assessment-2019-or-Movies-on-Flight
class Pair {
	int x;
	int y;

	public Pair(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
}

public class Ques1 {
	public static void main(String[] args) {
		int ar[] = {90, 85, 75, 60, 120,110,110, 150, 125};
		Arrays.sort(ar);
		int flightDuration = 220;
		int start = 0;
		int end = ar.length - 1;
		int prevDuration = Integer.MIN_VALUE;
		Pair res = null;
		while (start < end) {
			int sum = ar[start] + ar[end];
			if (sum > flightDuration) {
				end--;
			} else {
				if (sum > prevDuration) {
					if (res == null)
						res = new Pair(ar[start], ar[end]);
					else {
						res.x = ar[start];
						res.y = ar[end];
					}
					prevDuration = sum;
				} else if (sum == prevDuration) {
					if ((res.x < ar[start] && res.y < ar[start]) || (res.x < ar[end] && res.y < ar[end])) {
						res.x = ar[start];
						res.y = ar[end];
					}
				}

				if (sum == flightDuration) {
					start++;
					end--;
				}else if (sum < flightDuration) {
					start++;
				} 
			}
		}

		System.out.println(res.x+" "+res.y);
	}
//	private static void dfs(List<int []> prices, int r, int pos, int sum){
//
//		if(sum > r) return;
//		if(sum <= r && pos == prices.size()) {
//		    count++;
//		    return;
//		}
//
//		for(int x : prices.get(pos))
//		{
//		    sum +=x;
//		    dfs(prices, r, pos+1, sum);
//		    sum -=x;
//		}
//		}
}
