package com.jackson.homeworkone;

public class Question4 
{
	public int factorial(int number)
	{
		if(number != 1)
		{
			return number * factorial(number-1);
		}
		else
		{
			return 1;
		}
	}
}
