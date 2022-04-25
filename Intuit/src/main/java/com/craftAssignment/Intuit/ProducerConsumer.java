package com.craftAssignment.Intuit;

import java.util.LinkedList;
import java.util.Queue;

class Producer {
	Queue<Integer> messageQueue;
	int capacity;

	public Producer(Queue<Integer> messageQueue, int capacity) {
		this.messageQueue = messageQueue;
		this.capacity = capacity;
	}

	public void produce() throws InterruptedException {
		synchronized (messageQueue) {
			while (this.messageQueue.size() > capacity) {
				messageQueue.wait();
			}
			for (int i = 0; i < capacity; i++) {
				messageQueue.add(i);
				messageQueue.notify();
			}
			messageQueue.add(-1);
		}
	}
}

class Consumer {
	Queue<Integer> messageQueue;
	int capacity;

	public Consumer(Queue<Integer> messageQueue, int capacity) {
		this.messageQueue = messageQueue;
		this.capacity = capacity;
	}

	public void consume() throws InterruptedException {
		synchronized (messageQueue) {
			while (this.messageQueue.size() < 0) {
				messageQueue.wait();
			}
			for (int i = 0; i < capacity; i++) {
				if (messageQueue.peek() == -1)
					System.exit(0);
				System.out.println(messageQueue.poll());
				;
			}
			messageQueue.notify();
		}
	}
}

public class ProducerConsumer {
	public static void main(String[] args) {
		Queue<Integer> messageQueue = new LinkedList<Integer>();
		Producer producer = new Producer(messageQueue, 5);
		Consumer consumer = new Consumer(messageQueue, 5);
		Thread t = new Thread(() -> {
			try {
				producer.produce();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		Thread t1 = new Thread(() -> {
			try {
				consumer.consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		t1.start();
		t.start();
	}
}
