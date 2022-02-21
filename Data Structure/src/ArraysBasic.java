import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;
public class ArraysBasic {
	public static void main(String[] args) {
String inputString="dsg";
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(inputString);
        boolean isStringContainsSpecialCharacter = matcher.find();
        if(isStringContainsSpecialCharacter)
            System.out.println(inputString+ " contains special character");
        else    
            System.out.println(inputString+ " does NOT contain special character");
    }
public static int countHcf(int i,int max_d){
    if(i>max_d)
      return 0;
    int c=0;
    c+=countHcf(i+1, max_d)+(i-1);
    return c;
}
}
