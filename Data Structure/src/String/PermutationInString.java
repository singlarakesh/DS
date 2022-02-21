package String;

import java.util.HashMap;

public class PermutationInString {
public static void main(String[] args) {
	
	String str="abcc";
	  HashMap<Character,Integer> map=new HashMap<>();   
	     for(int i=0;i<str.length();i++){
	         char ch= str.charAt(i);
	         if(map.containsKey(ch)){
	            int l=map.get(ch);
	            map.put(ch,l+1);
	         }else{
	             map.put(ch,1);
	         }
	     }
	    int lm=0;
	    for(char s:map.keySet()){
	    int l=map.get(s);
	     System.out.println(l); 
	    if(l>1){
	    lm+=l;
	    }
	    } 
	        System.out.println(lm); 
	    }
}
