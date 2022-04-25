package dp;

public class CoinChangeTest {
	public static void main(String[] args) {
		int coins[] = { 1, 2, 5 };
		int amt = 11;
		coinPlb(coins, amt, 0);
	}

	private static int coinPlb(int[] coins, int amt, int i) {
		if (amt == 0 || i >= coins.length) {
			return 0;
		}
		
		if (coins[i] <= amt) {
			coinPlb(coins, amt-coins[i], i)+1
		} else {
		}

	}
}
