package com.revature.threadz;

public class ThreadDemo {

	public static void main(String[] args) {
		Thread extendThread= new ExtendThread();
		Thread implementThread= new Thread(new ImplementRunnable());
		extendThread.start();
		implementThread.start();
		implementThread.start();
		for(int i)//didnt finish
		// TODO Auto-generated method 

	}

}
