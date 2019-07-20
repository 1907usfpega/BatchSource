package com.revature.threadz;

public class ThreadsDemo {

	public static void main(String[] args) {
		Thread extendThread = new ExtendThread();
		Thread implementThread = new Thread(new ImplementRunnable());
		implementThread.setPriority(10);
		extendThread.setPriority(1);
		extendThread.start();
		implementThread.start();
			for(int i = 0; i < 100; i++) {
				System.out.println("Yo-Driver");
			}
	}
}
