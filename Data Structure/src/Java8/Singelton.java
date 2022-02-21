package Java8;

public class Singelton {
	private static volatile Person manager = null;

	private Singelton() {
		// TODO Auto-generated constructor stub
	}

	public static Person getManagerName() {
		synchronized (Singelton.class) {
			if (manager == null) {
				manager = new Person();
			}
		}
		return manager;
	}
}
