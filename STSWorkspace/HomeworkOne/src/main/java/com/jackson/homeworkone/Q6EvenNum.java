package com.jackson.homeworkone;

public class Q6EvenNum 
{
	public boolean isEven(int number)
	{
		double d = (double)number / 2.0;
		if(d - (number/2) == 0)
		{
			return true;
		}
		return false;
	}
}