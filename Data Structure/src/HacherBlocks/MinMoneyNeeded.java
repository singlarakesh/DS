package HacherBlocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinMoneyNeeded {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int f = scr.nextInt();
		int w = scr.nextInt();
		int bagw[] = new int[w];
		for (int i = 0; i < bagw.length; i++) {
			bagw[i] = scr.nextInt();
		}
		calcMinMoneyNeeded(bagw, w);
	}

	private static void calcMinMoneyNeeded(int[] bagw, int w) {
		// TODO Auto-generated method stub
		List<Integer> wt = new ArrayList<Integer>();
		List<Integer> price = new ArrayList<Integer>();
		int size = 0;
		for (int i = 0; i < bagw.length; i++) {
			if (bagw[i] != -1) {
				price.add(bagw[i]);
				wt.add(i + 1);
				size++;
			}
		}

		int capacity = w;
		int dp[][] = new int[size + 1][capacity + 1];
		// fill 0th row with infinity
		for (int i = 0; i <= capacity; i++)
			dp[0][i] = Integer.MAX_VALUE;

		// fill 0'th column with 0
		for (int i = 1; i <= size; i++)
			dp[i][0] = 0;

		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= capacity; j++) {
				if (wt.get(i - 1) <= j) {
					int res=dp[i][j - wt.get(i - 1)];
					if(res!=Integer.MAX_VALUE)
					dp[i][j] = Math.min(dp[i - 1][j], price.get(i - 1) + dp[i][j - wt.get(i - 1)]);
					else
						dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}

			}
		}
		System.out.println((dp[size][capacity] == Integer.MAX_VALUE) ? -1 : dp[size][capacity]);
	}
}
