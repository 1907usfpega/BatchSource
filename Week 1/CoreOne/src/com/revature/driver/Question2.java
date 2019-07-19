package com.revature.driver;

public class Question2 {
	public String run() {
		StringBuffer s = new StringBuffer();
		s.append("0 1 ");
		int a = 0;
		int b = 1;
		int c;
		for(int i = 0; i < 23; i++) {
			c = a + b;
			s.append(c + " ");
			a = b;
			b = c;
		}
		return s.toString();
	}
	protected void prompt() {
		System.out.println("Question 2: ");
		System.out.print("Solution: ");
	}
}
