package com.revature.corejavaassignment;

public class Q5 {

	public Q5() {
		// TODO Auto-generated constructor stub

		System.out.println("********** Q5 **********\n");
		String startString = "This part should remain.|This part should be removed.";
		System.out.println("Initial String:\n" + startString);
		String endString = subStringMaker(startString, 24);
		Q5Test tester = new Q5Test(endString, "This part should remain.");
		System.out.println("Sub-String:\n" + endString);
		System.out.println("\n\n");
	}
	public static String subStringMaker(String inString, int length) {
		String outString = String.valueOf(inString.charAt(0));
		for(int i = 1; i < length; i++)
			outString += String.valueOf(inString.charAt(i));
		return outString;
	}

}
