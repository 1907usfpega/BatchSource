package com.revature.threadz;

public class ThreadDemo extends Thread{

	public static void main(String[] args) {
		Thread extendThread = new ExtendThread();
		Thread implementThread = new  Thread(new ImplementRunnable());
		implementThread.setPriority(MAX_PRIORITY);
		extendThread.start();
		implementThread.start();
		
		for (int i = 0; i < 100; i++) {
			System.out.println("Yo-Driver");
		}
	}
}
