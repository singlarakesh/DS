package Pubmatic;

import java.util.List;

public class Producer implements Runnable {
	private List<String> buffer;

	public Producer(List<String> buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		String numbers[] = { "1", "2", "3" };
		for (String number : numbers) {
			synchronized (buffer) {
				buffer.add(number);
				System.out.println(Thread.currentThread().getName() + " added " + number);
			}
		}
		synchronized (buffer) {
		buffer.add(Main.EOF);
		}
	}

}
