package Caching;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class hello {
 final public static int a=10;
 private void getName() {
	 
 }
 public static void main(String[] args) {
	Set<Integer> s=new HashSet<>();
	System.out.println(s.add(10));
	System.out.println(s.remove(10));
	List<Integer> a=Arrays.asList(1,2,3);
	List<String> st=a.stream().map(item->item+"").collect(Collectors.toList());
	
}
}
