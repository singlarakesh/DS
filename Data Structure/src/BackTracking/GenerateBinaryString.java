package BackTracking;

public class GenerateBinaryString {
	public static void main(String[] args) {
		String str = "1??0?101";
//		generateBinaryString(str, 0);
		char ch[] = str.toCharArray();
		generateBSBackTrack(ch, 0);
	}

	private static void generateBSBackTrack(char[] ch, int i) {
		if (i == ch.length) {
			System.out.println(ch);
			return;
		}
		// TODO Auto-generated method stub
		if (ch[i] == '?') {
			ch[i] = '1';
			generateBSBackTrack(ch, i + 1);
			ch[i] = '0';
			generateBSBackTrack(ch, i + 1);
			ch[i] = '?';

		} else {
			generateBSBackTrack(ch, i + 1);
		}

	}

	private static void generateBinaryString(String str, int i) {
		if (i >= str.length()) {
			System.out.println(str);
			return;
		}

		if (str.charAt(i) == '?') {
			String s1 = str.substring(0, i) + "1" + str.substring(i + 1);
			generateBinaryString(s1, i + 1);
			String s2 = str.substring(0, i) + "0" + str.substring(i + 1);
			generateBinaryString(s2, i + 1);
		} else
			generateBinaryString(str, i + 1);
	}
}
