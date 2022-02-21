package String;

import java.util.HashMap;
import java.util.regex.Pattern;

public class ReverseStringWithoutEffectingSc {
	public static void main(String[] args) {
		String str = "a,b$c";
		reverseString(str);
	}

	private static void reverseString(String str) {
		int l = 0;
		int r = str.length() - 1;
		char s[] = str.toCharArray();
		while (l < r) {
			if (!Character.isAlphabetic(s[l])) {
				l++;
			} else if (!Character.isAlphabetic(s[r])) {
				r--;
			} else {
				char ch = s[l];
				s[l] = s[r];
				s[r] = ch;
				l++;
				r--;
			}
		}
		System.out.println(s);
	}

//	private static void reverseString(String str) {
//		// TODO Auto-generated method stub
//	Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
//	Matcher m = p.matcher("I am a string");
//	boolean b = m.find();
//
//	if (b)
//	   System.out.println("There is a special character in my string");
//	}
//	[32, 47], [58, 64], [91, 96] or [123, 126]. I
//	for (int i = 0; i < Str.length(); i++) {
//	    
//	    if (specialCharacters.contains(Character.toString(Str.charAt(i))))
//	    {
//	       
//	        System.out.println(Str.charAt(i)+": is a special character");
//	    }  
//	  }
}
