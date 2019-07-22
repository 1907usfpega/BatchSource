package threads;

public class ThreadDemo {

	public static void main(String[] args) {

		Thread extendThread = new ExtendThread();
		Thread implementThread = new Thread(new ImplementRunnable());
		
		extendThread.start();
		
		implementThread.setPriority(10); //<--Highest priority
		implementThread.start();
		
		for(int i = 0; i < 100; i++) {
			System.out.println("Ciao from MainThread");  //<--Threads compete to all print at same time. Each run is new order
		}
		
	}//end main

}//end ThreadDemo class
