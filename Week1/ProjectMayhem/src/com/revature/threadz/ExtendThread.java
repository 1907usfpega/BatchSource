package com.revature.threadz;

public class ExtendThread extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("\t\tHi-xtendedThread");
		}
	}
	
	public ExtendThread() {
		// TODO Auto-generated constructor stub
	}

}
