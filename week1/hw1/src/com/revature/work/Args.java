package com.revature.work;

public class Args {
	
	public static int attempt(String cmd) {
		System.out.println("\""+cmd+"\" has "+cmd.length()+" characters");
		return cmd.length();
	}

}
