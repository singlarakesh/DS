package Pubmatic;

import java.util.LinkedList;

public class Consumer implements Runnable {
	private LinkedList<String> buffer;

	public Consumer(LinkedList<String> buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			synchronized (buffer) {
				if (buffer.isEmpty())
					continue;
				if (buffer.get(0).equals("EOF")) {
					System.out.println(Thread.currentThread().getName() + "Existing.");
					break;
				} else {
					System.out.println(Thread.currentThread().getName() + " removed " + buffer.remove(0));
				}
			}
		}
	}

}
