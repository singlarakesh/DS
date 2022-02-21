package HacherBlocks;

public class APalindromeClassString {
	public static void main(String[] args) {
		String str = "nittin";
		int c = 0;
		for (int axis = 0; axis < str.length(); axis++) {
			for (int orbit = 0; (axis + orbit) < str.length() && (axis - orbit) >= 0; orbit++) {
				if (str.charAt(axis + orbit) == str.charAt(axis - orbit)) {
					c++;
				} else {
					break;
				}
			}
		}
		System.out.println(c);
	}
}
