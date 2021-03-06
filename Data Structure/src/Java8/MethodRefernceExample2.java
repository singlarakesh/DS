package Java8;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodRefernceExample2 {
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("Parusha", "Singla", 60), new Person("Hemant", "Singla", 65),
				new Person("Piyush", "Singla", 61));
		performConditional(people, p -> true, p -> System.out.println(p));
		performConditional(people, p -> true,System.out::println);
//		LocalDate date=LocalDate.now();
//		System.out.println(date);
//		LocalTime time=LocalTime.now().of(0, 0);
//		System.out.println(time);
//		Date d = new Date(0);
//		System.out.println(d);
	}

	private static void performConditional(List<Person> people, Predicate<Person> predicate,
			Consumer<Person> consumer) {
		// TODO Auto-generated method stub
		for (Person p : people) {
			if(predicate.test(p)) {
				consumer.accept(p);
			}
		}
	}
}
