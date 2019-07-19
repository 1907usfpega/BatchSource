package com.jackson.homeworkone;

public class Q17Interest 
{
	public double simpleInterest(double principal, double interestRate, int numYears) 
	{
		return principal * (1 + ((interestRate/100.0) * numYears));
	}
	
	/*public int getDays(int numYears)
	{
		int numDays = 0;
		for(int i = 1; i <= numYears;i++)
		{
			if(i % 4 == 0)
			{
				numDays++;
			}
		}
		numDays += (numYears*356);
		return numDays;
	}*/
}
