package com.jackson.homeworkone;

public class Q3ReverseString
{
	public String reverseString(String input)
	{
		if(input.equals(""))
		{
			return input;
		}
		return input.charAt(input.length()-1) + reverseString(input.substring(0, input.length() - 1));
	}
}