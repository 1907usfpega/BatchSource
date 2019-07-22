package com.revature.week1;

import java.util.Scanner;

//Reverse a string
public class Q3 {
	
	public static void reverseThis() {
	Scanner scn = new Scanner(System.in);

	String userInput;
	
	System.out.println("Enter a word: ");  //not in main method
	
	userInput=scn.nextLine();//stored what the user typed in.
	
	
	//loop to reverse the string, -1 because index starts at 0
	for(int i= userInput.length()-1; i >=0; i--) {
		System.out.print(userInput.charAt(i));
	}
	System.out.println();
	}
}
