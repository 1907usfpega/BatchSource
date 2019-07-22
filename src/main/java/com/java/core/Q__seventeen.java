package com.java.core;

import java.util.Scanner;

/*
 * Q17. Write a program that calculates the simple interest on the principal, 
 * rate of interest and number of years provided by the user. Enter principal, 
 * rate and time through the console using the Scanner class.
Interest = Principal* Rate* Time
 */
public class Q__seventeen {
public static Scanner sn = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println("calculate the simple interest on principal.  enter Principal");
	double principal = sn.nextDouble();
	System.out.println("enter Rate");
	double Rate = sn.nextDouble();
	System.out.println("enter Time");
	double Time = sn.nextDouble();
	Calculate(principal,Rate,Time);
	
	}
static void Calculate(double x, double y, double z) {
	double Interest = x*y*z;
	System.out.println("Interest: "+Interest);
}
}
