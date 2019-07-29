package com.revature.corejavaassignment;
import java.util.Scanner;

public class Q16 {

	public Q16(String args[]) {
		System.out.println("********** Q16 **********\n");
		int charCount = 0;
		String tempString = "";
		for(String s : args) {
			charCount += s.length();
		}
		int correctAnswer = 19;
		Q16Test tester = new Q16Test(correctAnswer, charCount);
		System.out.println("The input String " + " from args[] has length " + charCount);
		System.out.println("\n\n");
		  // Read user input
		// TODO Auto-generated constructor stub
	}

}
