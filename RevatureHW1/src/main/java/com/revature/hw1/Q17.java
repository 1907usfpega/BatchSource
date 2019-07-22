package com.revature.hw1;

/*
 * Q17 is a program that calculates the simple interest on the 
 * principal, rate of interest and number of years provided by the 
 * user. Enter principal, rate and time through the console using 
 * the Scanner class.
 * Interest = Principal* Rate* Time
 */

public class Q17 {
	
	
	/*
	 * Returns val based on formula for interest.
	 * PARAMS: principal, rot as a percentage, time in years
	 * (EX: 18 months = 1.5 years)
	 */
	public static double getInterest(double principal, double roi, double time)
	{
		return principal * roi * time;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
