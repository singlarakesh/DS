
class A {
	void prints() {
		System.out.println("in A");
	}
}

class B extends A {
	static class c {
	}

	void prints() {
		System.out.println("in B");
	}
}

public class datatype {
	public static void main(String[] args) {
		A ref = new A();
		B ref1 = new B();
		ref = ref1;
		ref.prints();
//		System.out.print(ref.print());
	}
}
