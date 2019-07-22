package com.revature.threadz;

public class ThreadDemo {

	public static void main(String[] args) {
		Thread extThd=new ExtendThread();
		Thread impRun=new Thread(new ImplementRunnable());
		impRun.setPriority(10);
		extThd.start();
		impRun.start();
		for (int i=0;i<100;i++) {
			System.out.println("Hellooo nurse");
		}
	}

}
