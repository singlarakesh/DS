package Java8;

import java.util.Optional;


public class OptionalClass {
//	Logger logger=LoggerFactory.get
	public static void main(String[] args) {
		// Without using Optional Class
		// We cant check so many null check exception
		String str[] = new String[10];
//		String word = str[5].toUpperCase();
//		System.out.println(word);
		// with help of Optional Class
		Optional<String> checkNull = Optional.ofNullable(str[5]);
		if (checkNull.isPresent()) {
			System.out.println(str[5]);
		} else {
			System.out.println("String is null");
		}
	}
}
