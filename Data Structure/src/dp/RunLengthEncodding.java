package dp;

public class RunLengthEncodding {
	public static void main(String[] args) {
		String str = "wwwwaaadexxxxxx";
		String res = "";
		for (int i = 0; i < str.length();) {
			char ch = str.charAt(i);
			for (int j = i + 1; j < str.length();) {
				if (ch == str.charAt(j)) {
					j++;
					if (str.length() == j) {
						res += ch + "" + (j-i);
						i = j;
						break;
					}
				} else {
					res += ch + "" + (j-i);
					i = j;
					break;
				}
			}
		}
		System.out.println(res);
	}
}
