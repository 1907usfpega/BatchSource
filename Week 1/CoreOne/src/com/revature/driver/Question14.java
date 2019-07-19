package com.revature.driver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Question14 {
	private static String three =  "I am learning Core Java";
	protected String[] split;
	protected String run(String s) {

			switch (s.trim()) {
			case "1":
				System.out.println("Enter value: ");
				Scanner scan = new Scanner(System.in);
				String value = scan.nextLine();
				scan.close();
				if(validInput(value)) {
					double sq = Math.sqrt(Double.parseDouble(value));
					return ("Square root of " + value + " is " + sq);
				} else {
					return "";
				}
			case "2":
				DateFormat dateForm = new SimpleDateFormat("MM/dd/yyy");
				Date date = new Date();
				return (dateForm.format(date));
			case "3":
				split = three.split(" ");
				return ("String is stored in a string array");
			default:
				return "You didn't do type a correct value";
				
			}
			
		
	}

	protected static boolean validInput(String s) {
		try {
			Double.parseDouble(s);
			return true;

		} catch (NumberFormatException e) {
			System.out.println("Input is not valid. Returning empty string ");
		}
		return false;
	}
	protected void prompt() {
		System.out.println("Question 14:");
		System.out.println("Pick a case from below:");
		System.out.println("1. Find sqr Root");
		System.out.println("2. Display today's date");
		System.out.println("3. Split the string \"I am learning Core Java\" into a string array");
	}
}
