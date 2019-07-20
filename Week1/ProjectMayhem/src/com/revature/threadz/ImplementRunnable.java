package com.revature.threadz;

public class ImplementRunnable implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			System.out.println("\t\t\t\tWhat's up Runnable?");
		}
	}
	
	public ImplementRunnable() {
		// TODO Auto-generated constructor stub
	}

}
