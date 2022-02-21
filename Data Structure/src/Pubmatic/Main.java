package Pubmatic;

import java.util.LinkedList;

public class Main {
	public static String EOF = "EOF";

	public static void main(String[] args) {
		LinkedList<String> buffer = new LinkedList<String>();
		Thread proThread=new Thread(new Producer(buffer));
		proThread.setName("Producer");
		Thread coThread1=new Thread(new Consumer(buffer));
		coThread1.setName("Consumer1");
		Thread coThread2=new Thread(new Consumer(buffer));
		coThread2.setName("Consumer2");
		
		proThread.start();
		coThread1.start();
		coThread2.start();
	}
}
