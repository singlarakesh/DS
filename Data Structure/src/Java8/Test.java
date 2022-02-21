package Java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		Person p1=Singelton.getManagerName();
		p1.setName("Parusha");
		Person p2=Singelton.getManagerName();
		p2.setName("cf");
		System.out.println(p1.getName());
//		List<Integer> ar=new ArrayList<Integer>();
//		ar.add(80);
//		ar.add(20);
//		Comparator<Integer> c=(Integer o1, Integer o2)->{return o2-o1;};
//		Collections.sort(ar,c);
//		System.out.println(ar);
//        
	}
}
