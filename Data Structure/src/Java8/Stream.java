package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {
	public static void main(String[] args) {
//      int ar[]= {1,2,3,4};
      List<Integer> list=Arrays.asList(2,3,4,5);
      List<String> names = Arrays.asList("Reflection","Collection","Stream");
      List square = list.stream().map(i->i*i).collect(Collectors.toList());
       list.stream().map(x->x*x).forEach(y->System.out.println(y));
      System.out.println(square);System.out.println(list);
      List<String> result = names.stream().filter(s->s.startsWith("S")).collect(Collectors.toList());
      List<String> namess = Arrays.asList("Reflection","Collection","Stream");
      List res= namess.stream().sorted().collect(Collectors.toList());
	}
}
