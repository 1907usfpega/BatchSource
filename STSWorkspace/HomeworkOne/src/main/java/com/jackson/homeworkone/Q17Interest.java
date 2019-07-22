package com.jackson.homeworkone;

public class Q17Interest 
{
	public double simpleInterest(double principal, double interestRate, int numYears) 
	{
		//calculate simple interest using the formula: p * (1 + (r/100) * y)
		return principal * (1 + ((interestRate/100.0) * numYears));
	}
}
