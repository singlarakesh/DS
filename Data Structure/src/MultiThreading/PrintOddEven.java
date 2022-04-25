package MultiThreading;

public class PrintOddEven {
	int counter;
	int n;

	public PrintOddEven(int n) {
		this.counter = 1;
		this.n = n;
	}

	public void printEvenNumber() throws InterruptedException {
		synchronized (this) {
			while (counter < n) {
				while (counter % 2 != 0) {
					wait();
				}
				System.out.println(counter);
				counter++;
				notify();
			}
		}
	}

	public void printOddNumber() throws InterruptedException {
		synchronized (this) {
			while (counter < n) {
				while (counter % 2 == 0) {
					wait();
				}
				System.out.println(counter);
				counter++;
				notify();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		PrintOddEven p = new PrintOddEven(7);
		Thread t = new Thread(() -> {
			try {
				p.printOddNumber();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		Thread t2 = new Thread(() -> {
			try {
				p.printEvenNumber();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		t.start();
		t.join();
		t2.start();
	}
}
