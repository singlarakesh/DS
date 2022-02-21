package Pubmatic;

public class Message {
	String message;
	boolean empty = true;

	public synchronized String read() {
		while (empty)
			;// if message is empty then keep looping.
		empty = true;// Reader reads the message and marks empty as true.
		return message;// Reader reads the message.
	}

	public synchronized void write(String message) {
		while (!empty)
			;// if message is not empty then keep looping.
		this.message = message;// Writer writes the message.
		empty = false;// Now make empty as false.
	}
}
