package LeetCode;

public class FindTheDiff {
	public static void main(String[] args) {
		char c='';
        for(int i=0;i<s.length();i++){
             c=c^s.charAt(i);            
        }
        for(int i=0;i<t.length();i++){
            c=c^t.charAt(i);
        }
        return c;
        }
}
