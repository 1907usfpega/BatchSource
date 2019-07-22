package com.jackson.homeworkone;

public class Q3ReverseString
{
	public String reverseString(String input)
	{
		//if we are at the end of the string
		if(input.equals(""))
		{
			return input;
		}
		else
		{
			//return the char at the end appended to the front, 
			//with a recursive call using a new string that removes the last character
			return input.charAt(input.length()-1) + reverseString(input.substring(0, input.length() - 1));
		}
	}
}