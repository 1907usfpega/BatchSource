package com.revature.corejavaassignment;

import java.util.ArrayList;

public class Q8 {

	public Q8() {
		// TODO Auto-generated constructor stub
		System.out.println("********** Q8 **********\n");
		ArrayList<String> testAL = new ArrayList();
		testAL.add("karan");	testAL.add("madam");	testAL.add("tom");
		testAL.add("civic");	testAL.add("radar");	testAL.add("jimmy");
		testAL.add("kayak");	testAL.add("john");	testAL.add("refer");
		testAL.add("billy");	testAL.add("did");
		String tempString = "";
		String tempRevString = "";
		System.out.println("Original ArrayList:\n" + testAL);
		int len = testAL.size() - 1;
		for(int i = len; i >= 0; i--) {
			tempString = testAL.get(i);
			if(!tempString.equals(reverseString(tempString)))
				testAL.remove(i);
		}
		System.out.println("Palindromes Only:\n" + testAL);
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
