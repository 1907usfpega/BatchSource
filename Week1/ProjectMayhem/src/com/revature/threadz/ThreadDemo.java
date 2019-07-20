package com.revature.threadz;

public class ThreadDemo {

	public ThreadDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread extendThread = new ExtendThread();
		Thread implementThread = new Thread(new ImplementRunnable());
		implementThread.setPriority(10);
		extendThread.start();
		implementThread.start();
		for (int i = 0; i < 100; i++) {
			System.out.println("Yo-Driver");
			
		}
	}

}
