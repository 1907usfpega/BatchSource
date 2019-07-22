package com.jackson.homeworkone;

public class Q6EvenNum 
{
	public boolean isEven(int number)
	{
		//declare a double, which is made from dividing number in half
		double d = (double)number / 2.0;
		//if the double d minus the integer result of number / 2 is equal to 0
		if(d - (number/2) == 0)
		{
			//we have no remainder, therefore it divides evenly into it
			return true;
		}
		return false;
	}
}