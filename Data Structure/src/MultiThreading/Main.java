package MultiThreading;

public class Main {
	public static void main(String[] args) {
//      Thread t=new Thread(new Runnable() {
//		
//		@Override
//		public void run() {
//			System.out.println("we are going to start thread "+Thread.currentThread().getName());
//			System.out.println(Thread.currentThread().getPriority());
//		}
//	});
		Thread t = new Thread(() -> {
  			System.out.println("we are going to start thread "+Thread.currentThread().getName());
  			System.out.println(Thread.currentThread().getPriority());
		});
		t.setName("worker node");
		// 1-10
		t.setPriority(Thread.MAX_PRIORITY);
		System.out.println("we are going to start thread " + Thread.currentThread().getName());
		t.start();
		System.out.println("we are going to start thread " + Thread.currentThread().getName());
	}
}
