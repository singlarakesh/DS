package HacherBlocks;

import java.util.Scanner;

//Prateek went to purchase fruits mainly apples, mangoes and oranges. There are N different fruit sellers in a line. Each fruit seller sells all three fruit items, but at different prices. Prateek, obsessed by his nature to spend optimally, decided not to purchase same fruit from adjacent shops. Also, Prateek will purchase exactly one type of fruit item (only 1kg) from one shop. Prateek wishes to spend minimum money buying fruits using this strategy. Help Prateek determine the minimum money he will spend. If he becomes happy, he may offer you discount on your favorite course in Coding Blocks ;). All the best!
//1
//3
//1 50 50
//50 50 50
//1 50 50
public class BuyFruit {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tc = scan.nextInt();
		for (int ti = 1; ti <= tc; ti++) {
			int n = scan.nextInt();
			int[][] arr = new int[n][3];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < 3; j++) {
					arr[i][j] = scan.nextInt();
				}
			}
			System.out.println(maxPrice(arr));
		}
	}

	public static int maxPrice(int[][] arr) {
		int n = arr.length;
		int[][] strg = new int[arr.length][arr[0].length];
		for (int i = 0; i < arr[0].length; i++) {
			strg[0][i] = arr[0][i];
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					// include apples
					strg[i][j] = Math.min(arr[i][j] + strg[i - 1][1], arr[i][j] + strg[i - 1][2]);
				}
				if (j == 1) {
					// include oranges
					strg[i][j] = Math.min(arr[i][j] + strg[i - 1][0], arr[i][j] + strg[i - 1][2]);
				}
				if (j == 2) {
					// include mango
					strg[i][j] = Math.min(arr[i][j] + strg[i - 1][0], arr[i][j] + strg[i - 1][1]);
				}
			}
		}

		return Math.min(strg[n - 1][0], Math.min(strg[n - 1][1], strg[n - 1][2]));
	}
}
