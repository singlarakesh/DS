package HacherBlocks;

import java.util.Scanner;

public class AChewbacca {
	public static void main(String[] args) {
      Scanner scr=new Scanner(System.in);
      Long num=scr.nextLong();
      int c=Long.toString(num).length();
      String s="";
      while(num!=0) {
    	  Long r=num%10;
    	  Long dif=9-r;
    	  if(c==1 && dif==0) {
    		  s=r+s;
    		  break;
    	  }
    	  if(dif<r) {
    		  s=dif+s;
    	  }else {
    		  s=r+s;
    	  }
    	  c--;
    	  num=num/10;
      }
      if(s=="")
    	  System.out.println(num);
      System.out.println(s);
	}
}
