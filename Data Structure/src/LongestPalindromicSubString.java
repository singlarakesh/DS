import java.util.Scanner;

public class LongestPalindromicSubString {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		String str = scr.nextLine();
		boolean[][] dp = new boolean[str.length()][str.length()];
		int len = 0;
		int si=0;
		int ei=0;
		int maxLen=0;
		int c=0;
		for (int g = 0; g < str.length(); g++) {
			for (int i = 0, j = g; j < str.length(); j++, i++) {
				if (g == 0) {
					dp[i][j] = true;
				} else if (g == 1) {
					if (str.charAt(i) == str.charAt(j)) {
						dp[i][j] = true;
					} else {
						dp[i][j] = false;
					}
				} else {
					if (str.charAt(i) == str.charAt(j) && dp[i+1][j-1]) {
						dp[i][j] = true;
					} else {
						dp[i][j] = false;
					}
				}
				if(dp[i][j]) {
					len=g+1;
					c++;
				}
				if(maxLen<len){
				    	maxLen=len;
				   		si=i;
				     	ei=j; 
				}
			}
		}
		System.out.println(maxLen);
		System.out.println(str.substring(si, ei+1));
		System.out.println(c);
	}
	
}
