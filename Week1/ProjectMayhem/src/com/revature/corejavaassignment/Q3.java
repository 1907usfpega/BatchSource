package com.revature.corejavaassignment;

public class Q3 {

	public Q3() {
		// TODO Auto-generated constructor stub
		System.out.println("********** Q3 **********\n");
		String testString = "THIS STRING SHOULD BE REVERSED. "
				+ ".desrever neeb sah gnirts siht";
		System.out.println("Forward String:\n"+ testString);
		testString = reverseString(testString);
		System.out.println("Reversed String:\n" + testString);
		System.out.println("\n\n");
	}
	public static String reverseString(String inString) {
		for(int i = 0; i < inString.length()/2; i++) {
			inString = (inString.substring(0,  i) +
						inString.substring(inString.length() - i - 1, inString.length() - i) +
						inString.substring(i + 1, inString.length() - i - 1) +
						inString.substring(i, i + 1) +
						inString.substring(inString.length() - i, inString.length()));
		}
		return inString;
	}

}
