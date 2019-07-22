package com.revature.threadz;

public class ExtendThread extends Thread {
	@Override
	public void run() {
		for(int i=0;i<100;1++) {
			System.out.println("\1");
		}
	}
}
