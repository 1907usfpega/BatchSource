package com.jackson.homeworkone;

public class Q4Factorial
{
	public int factorial(int number)
	{
		//if we are at the end
		if(number == 1)
		{
			return 1;
		}
		else
		{
			//recursive call to the number-1
			return number * factorial(number-1);
		}
	}
}
