package com.revature.driver;

public class Question5 {

	// Sub string method
	public String run(int idx, String in) {
		// checks if the inx value is improper
		try {
			char[] charArray = in.toCharArray();
			StringBuffer buf = new StringBuffer();
			for (int i = 0; i < (int) (idx) + 1; i++) {
				buf.append(charArray[i]);
			}
			return buf.toString();
		} catch (ArrayIndexOutOfBoundsException aiobe) {
			System.out.println("Index was too large! Returning original string: ");
			return in;
		}
	}

	protected void prompt1() {
		System.out.println("Question 5: Please enter index to make a sub string.");
	}

	protected void prompt2() {
		System.out.println("Question 5: Please enter your String to make a sub string.");
	}
	//checks if it is a valid index
	public boolean validIndex(String s) {
		try {
			double a = Double.parseDouble(s);
			if (a > -1 && a == (int) a) {
				return true;
			} else {
				System.out.println("Input is not valid");
			}
		} catch (NumberFormatException e) {
			System.out.println("Input is not valid");
		}
		return false;
	}

}
