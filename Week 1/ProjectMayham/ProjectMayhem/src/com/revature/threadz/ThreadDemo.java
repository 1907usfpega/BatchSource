package com.revature.threadz;

public class ThreadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread extendThread = new ExtendThread();
		Thread implementThread = new Thread(new ImplementRunnable());
		
		extendThread.start();
		implementThread.start();
		
		for(int i = 0; i < 100; i++) {
			System.out.println("Yo - Driver");
		}
		
		
	}

}
