package Greedy;

public class GasStation {
	public static void main(String[] args) {
		int gas[] = { 1, 2, 3, 4, 5 };
		int cost[] = { 3, 4, 5, 1, 2 };
		int i = 0;
		int j = 0;
		int start = -1;
		int extraAmt = 0;
		while (i < gas.length) {

			if (start == i) {
				return start;
			}
			if (cost[i] < gas[j]) {
				start = i;
				extraAmt += gas[i] - cost[j];
			} else if (cost[i] > gas[j] && extraAmt > 0) {
				extraAmt -= cost[i] - gas[j];
				if(extraAmt<0) {
					return -1;
				}
			}
			i++;
			j++;
			if (i >= gas.length) {
				if (start != -1) {
					return -1;
				} else {
					i = 0;
				}
			}
		}
	}
}
