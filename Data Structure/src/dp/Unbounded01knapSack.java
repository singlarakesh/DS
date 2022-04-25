package dp;

public class Unbounded01knapSack {
	public static void main(String[] args) {
		int wt[] = { 1, 2, 3, 4 };
		int profit[] = { 10, 40, 10, 30 };
		int capacityOfKnapSack = 4;
		System.out.println(unboundedKnapsack(wt, profit, 0, capacityOfKnapSack));;
	}

	private static int unboundedKnapsack(int[] wt, int[] profit, int i, int capacityOfKnapSack) {
		// TODO Auto-generated method stub
		if (i >= wt.length || capacityOfKnapSack < 0) {
			return 0;
		}
		if (wt[i] < capacityOfKnapSack) {
			int includeWt = unboundedKnapsack(wt, profit, i + 1, capacityOfKnapSack - wt[i]) + profit[i];
			int excludeWt = unboundedKnapsack(wt, profit, i + 1, capacityOfKnapSack);
			return Math.max(includeWt, excludeWt);
		} else {
			return unboundedKnapsack(wt, profit, i + 1, capacityOfKnapSack);
		}
	}
}
