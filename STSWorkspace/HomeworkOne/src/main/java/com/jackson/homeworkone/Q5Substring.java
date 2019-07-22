package com.jackson.homeworkone;

public class Q5Substring 
{
	public String mySubstring(String str, int idx)
	{
		//if our idx is not within the actual string
		if(idx < 0 || idx > str.length())
		{
			return "Index Out of Bounds error";
		}
		//create a new char array
		char[] toArray = new char[idx];
		//
		for(int i = 0; i < toArray.length; i++)
		{
			toArray[i] = str.charAt(i);
		}
		//recombine char array into a string
		String s = String.copyValueOf(toArray);
		return s;
	}
}
