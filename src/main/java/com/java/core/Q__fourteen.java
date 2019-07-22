package com.java.core;
import java.lang.Math;
import java.util.Date;
import java.util.Scanner;

public class Q__fourteen {
/*
 * Q14. 
Write a program that demonstrates the switch case. Implement the following functionalities in the cases:java
Case 1: Find the square root of a number using the Math class method.
Case 2: Display today’s date.
Case 3: Split the following string and store it in a string array. “I am learning Core Java”
 * 
 * */
	public static Scanner sc = new Scanner(System.in);
	static String x = "YES";
	public static final String  MATH= "MATH";
	public static final String DATE="DATE";
	public static final String STRING="STRING";
	public static String[]str;
	public static void main(String[] args) {
		// TODO Auto-generated method stub



boolean cont = true;
while(cont) {
	System.out.println("MATH        DATE          STRING");
	System.out.println("Enter a task:");
	String choice = sc.nextLine();
	switch(choice.toUpperCase()){
	case MATH:
		mathMethod();
		break;
	case DATE :
		dateMethod();
		break;
	case STRING:
		stringMethod();
		break;
	
	}
	
	System.out.print("continue?");
	String answ = sc.nextLine();
	if(answ.toUpperCase().equals(x)) {
		cont = true;}
	else {
		cont=false;}
}//while loop
	System.out.println("exited the loop");	
	}//main method
	
	//math methods
	public static void mathMethod() {
		System.out.println("Square root function, enter a integer");
		int x = Integer.parseInt(sc.nextLine());
		double y= Math.sqrt(x);
		System.out.println("The square root of "+x+" is "+y);
		}
	
		public static void dateMethod() {
			Date date = new Date();
			System.out.println("todays date: "+date.getDate());		
		}
		
		public static void stringMethod() {
			System.out.println("string function, enter a string: ");
			String strg = sc.nextLine();
			String[] strArray= strg.split(" ");
			for(String c:strArray) {
				System.out.println(c);
			}
		}
	

}
