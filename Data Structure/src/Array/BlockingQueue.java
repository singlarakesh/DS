package Array;

import java.util.LinkedList;
import java.util.Queue;

import java.util.logging.Level;
import java.util.logging.Logger;

class Producer implements Runnable {
	private Queue<Integer> q;
	private int size;

	public Producer(Queue<Integer> q, int size) {
		this.q = q;
		this.size = size;
	}

	@Override
	public void run() {
		for (int i = 0; i < 7; i++) {
			System.out.println("Produced: " + i);
			try {
				produce(i);
			} catch (InterruptedException e) {
				Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, e);
			}
		}
	}

	private void produce(int i) throws InterruptedException {
		// TODO Auto-generated method stub
		while (q.size() == size) {
			synchronized (q) {
				q.wait();
			}
		}
		synchronized (q) {
			q.add(i);
			q.notifyAll();
		}
	}
}

class Consumer implements Runnable {
	private Queue<Integer> q;
	private int size;

	public Consumer(Queue<Integer> q, int size) {
		this.q = q;
		this.size = size;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				System.out.println("Consumed: " + consume());
//				Thread.sleep(50);
			} catch (InterruptedException ex) {
				Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
			}

		}
	}

	private int consume() throws InterruptedException {
		// TODO Auto-generated method stub
		while (q.isEmpty()) {
			synchronized (q) {
				System.out.println(
						"The queue is empty " + Thread.currentThread().getName() + " is waiting , size: " + q.size());
				q.wait();
			}
		}
		synchronized (q) {
			q.notifyAll();

			return q.poll();
		}
	}

}

public class BlockingQueue {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<Integer>();
		int size = 5;

		Thread prodThread = new Thread(new Producer(q, size), "Producer");
		Thread consThread = new Thread(new Consumer(q, size), "Consumer");
		prodThread.start();
		consThread.start();
	}
//	public void produce() throws InterruptedException {
//		while (q.size() == size) {
//			q.wait();
//		}
//		for (int i = 0; i < 5; i++) {
//			q.add(i);
//		}
//		q.notifyAll();
//	}
//
//	public void consume() throws InterruptedException {
//		while (q.isEmpty()) {
//			q.wait();
//		}
//		System.out.println(q.poll());
//		notifyAll();
//	}
}
