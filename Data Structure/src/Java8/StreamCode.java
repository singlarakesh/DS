package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamCode {

	public static void main(String[] args) {
		int ar[] = { 105, 20, 50, 5, 78, 16 };
//		Stream numbers = Stream.of(ar);
		List<Integer> list = new ArrayList<>();
		list.add(105);
		list.add(20);
		list.add(50);
		list.add(5);
		list.add(78);
		List<Integer> ans = list.stream().filter(el -> el > 10).collect(Collectors.toList());
		System.out.println(ans);

		/*
		 * Question 2 Find Out even number that exist in list
		 */
		ans = list.stream().filter(el -> el % 2 == 0).collect(Collectors.toList());
		System.out.println(ans);

		/*
		 * Question 3 Find out all numbers starting with 1
		 */

		List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
		myList.stream().map(el -> el + "").filter(el -> el.startsWith("1")).forEach(System.out::println);

		/*
		 * Question 4 Find duplicates
		 */
		myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		Set<Integer> set = new HashSet();
		myList.stream().filter(el -> !set.add(el)).forEach(System.out::println);
		// find total elements in list
		System.out.println(myList.stream().count());
		// Find the maximum element in list
		System.out.println(myList.stream().max(Integer::compareTo).get());
        //		sorted 
		myList.stream().sorted().forEach(System.out::print);
        //		sorted in reverse order
		myList.stream().sorted(Collections.reverseOrder()).forEach(System.out::print);
		
		
		
        String input = "Java Hungry Blog Alive is Awesome";

        Character result = input.chars() // Stream of String       
                                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase         
                                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count 
                                .entrySet()
                                .stream()
                                .filter(entry -> entry.getValue() == 1L)
                                .map(entry -> entry.getKey())
                                .findFirst()
                                .get();
        System.out.println(result);    

	}
}
