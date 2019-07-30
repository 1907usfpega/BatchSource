package com.revature.assignment1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Assignment #1 Question 14
 *Write a program that demonstrates the switch case. Implement the following functionalities in
 *the cases:java
 *Case 1: Find the square root of a number using the Math class method.
 *Case 2: Display today�s date.
 *Case 3: Split the following string and store it in a string array.
 *�I am learning Core Java�
 * 
 * @author Kyle Kolstad
 *
 * 
 */
public class SwitchCase {

	private String string = "I am learning Core Java";
	private String [] array;
	
	public SwitchCase() {
		
	}
	
	public void determineCase(int caseNumber) {
		
		switch(caseNumber) {
			case 1: 
				System.out.println("The Square Root Of 4 is: " + Math.sqrt(4));
				break;
			case 2: 
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				Date date = new Date();
				System.out.println(dateFormat.format(date));
				break;
			case 3:
				System.out.println("String Before Split: ");
					System.out.println(string);
				array = string.split("\\s");

				break;
		}
	}
	public String [] getArray() {
		return array;	
	}
	

}
