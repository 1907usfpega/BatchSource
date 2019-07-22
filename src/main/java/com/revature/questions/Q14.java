package com.revature.questions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*Q14. 
Write a program that demonstrates the switch case. Implement the following functionalities in the cases:java
Case 1: Find the square root of a number using the Math class method.
Case 2: Display today’s date.
Case 3: Split the following string and store it in a string array.
       	 “I am learning Core Java”
*/
public class Q14 {

	public static String doSwitch(int x) {
		switch (x) {
		case 1:
			return findSquareRoot(64);
		case 2:
			return displayDate();
		case 3:
			return splitString();
		default:
			return null;
		}
	}

	private static String findSquareRoot(double num) {
		String s = Double.toString(Math.sqrt(num));
		System.out.println(s);	
		return s;
	}

	private static String splitString() {

		String str = "I am learning Core Java";
		String strArray[];
		
		//uses splin function built in String
		strArray = str.split("");
		System.out.println(strArray.length);
		return Integer.toString(strArray.length);
		
	}

	//display today's date
	private static String displayDate() {
		//format month, day, year
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		//create a Date instance
		Date today = new Date();
		
		//print instance formated
		String s = dateFormat.format(today);
		System.out.println(s); 
		return s;
	}
}
