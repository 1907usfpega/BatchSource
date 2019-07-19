package com.revature.driver;

public class Question3 {

	public String run(String s) {
		for (int i = s.length() - 1; i > -1; i--) {
			s += s.charAt(i);
		}
		s = s.substring(s.length() / 2);
		return s;
	}

	protected void prompt() {
		System.out.println("Question 3: Enter the string you want to reverse.");
	}

	protected void prompt2() {
		System.out.print("Solution:");
	}
}
