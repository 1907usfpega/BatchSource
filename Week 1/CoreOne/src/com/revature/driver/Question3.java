package com.revature.driver;

public class Question3 {

	public String run(String s) {
		int length = s.length();
		for (int i = length - 1; i > -1; i--) {
			s += s.charAt(i);
		}
		return s.substring(length);
	}
	protected void prompt() {
		System.out.println("Question 3:");
		System.out.print("Solution:");
	}

}
