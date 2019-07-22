package com.revature.assignment1;

/**
 * Assignment #1 Question 17
 *Write a program that calculates the simple interest on the principal, rate of interest and
 *number of years provided by the user. Enter principal, rate and time through the console using
 *the Scanner class.
 *Interest = Principal* Rate* Time
 * 
 * @author Kyle Kolstad
 *
 * 
 */
public class SimpleInterest {

	private double simpleInterest;
	
	public SimpleInterest() {
		
	}
	
	public void calculateSimpleInterest(double principle, double rate, double time){
		
		simpleInterest = (principle * rate * time) / 100;
		System.out.println("the simple interest is: $" + simpleInterest);
	}
}
