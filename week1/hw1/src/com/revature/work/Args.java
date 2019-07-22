package com.revature.work;

public class Args {
	//takes a string and prints its length
	//the question stated that it had to take a string 
	//from the command line, but I did that in Driver
	public static int attempt(String cmd) {
		System.out.println("\""+cmd+"\" has "+cmd.length()+" characters");
		return cmd.length();
	}

}
