package Java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class ClientClass {

	public static void main(String[] args) throws CloneNotSupportedException {
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		// TODO Auto-generated method stub
		Person person=new Person();
	    person.clone();
		List<Person> people = Arrays.asList(new Person("Parusha", "Singla", 60), new Person("Hemant", "Singla", 65),
				new Person("Piyush", "Singla", 61));
//		where we are  using comparable
//		Collections.sort(people);
//		here we are usiing comparator compare method
		Collections.sort(people,person);
		System.out.println(people);
//using lambda ini F.I
		Vehicals v = () -> System.out.println("Hello");
		v.typeOfVehical();
//Predicate FI defined by java in util package
		Predicate<Integer> p = i -> i < 10;
		Predicate<Integer> p2 = i -> i == 5;
		System.out.println(p.test(11));
		System.out.println(p.and(p2).test(5));
		System.out.println(p.and(p2).negate().test(5));

//	    Supplier
//      Consumer
		//Method Reference 
		//Phele lambda dekho
		Thread t=new Thread(()->{printName();});
		t.start();
		//Method Reference will make lambda more clear
		//object::methodName
		//parameter should be equal not applies everywhere
		Thread t1=new Thread(ClientClass::printName);
		t1.start();
	}
	public static void printName() {
		System.out.println("Parusha");
	}
}
