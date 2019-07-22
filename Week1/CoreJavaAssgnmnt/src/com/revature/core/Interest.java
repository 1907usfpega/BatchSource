/**
 * 
 */
package com.revature.core;

import java.util.Scanner;

/**
 * @author MajorKey
 *Question 17
 */
public class Interest {

	public void calculateInterest() {
		System.out.println("Hello. I am here to help you calculate the simple interest on anything you have.");
		
		Scanner keyboard = new Scanner(System.in);
		double principle, rate;
		int time;
		
		System.out.println("So let's start......");
		System.out.print("What is your principle? :");
		principle = keyboard.nextDouble();
		System.out.print("What is your rate(%)? :");
		rate = keyboard.nextDouble() / 100;
		System.out.print("For how many years? :");
		time = keyboard.nextInt();
		System.out.println("\tYour simple interest is " + (principle * rate * time));
		
	}
	
	public static void main(String [] args) {
		Interest interest = new Interest();
		interest.calculateInterest();
	}
}
