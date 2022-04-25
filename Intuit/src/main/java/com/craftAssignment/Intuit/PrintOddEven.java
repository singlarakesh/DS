package com.craftAssignment.Intuit;

public class PrintOddEven {
	static int num = 1;

	public void printOddNumber() throws InterruptedException {
		synchronized (this) {
			while (num % 2 == 0) {
				this.wait();
			}
			System.out.println(num);
			num++;
			notify();
		}
	}

	public void printEvenNumber() throws InterruptedException {
		synchronized (this) {
			while (num % 2 != 0) {
				this.wait();
			}
			System.out.println(num);
			num++;
			notify();
		}
	}

	public static void main(String[] args) {
		PrintOddEven obj = new PrintOddEven();
		Thread t1 = new Thread(() -> {
			try {
				obj.printOddNumber();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		Thread t = new Thread(() -> {
			try {
				obj.printEvenNumber();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		t1.start();
		t.start();
	}
}
