package com.revature.driver;

public class Question5 {
	protected String run(int idx, String in) {
		char[] charArray = in.toCharArray();
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < idx + 1; i++) {
			buf.append(charArray[i]);
		}
		return buf.toString();
	}

	protected void prompt1() {
		System.out.println("Question 5: Please enter index to make a sub string.");
	}

	protected void prompt2() {
		System.out.println("Question 5: Please enter your String to make a sub string.");
	}

}
