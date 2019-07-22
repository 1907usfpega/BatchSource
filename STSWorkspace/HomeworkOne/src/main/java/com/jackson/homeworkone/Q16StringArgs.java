package com.jackson.homeworkone;

public class Q16StringArgs 
{
	public int numChars(String input)
	{
		int sum = 0;
		char[] arr = input.toCharArray();
		for(char c : arr)
		{
			//increment sum for each char in the char array from string input
			sum++;
		}
		return sum;
	}
}
