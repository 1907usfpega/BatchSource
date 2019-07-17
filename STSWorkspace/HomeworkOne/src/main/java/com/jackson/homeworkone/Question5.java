package com.jackson.homeworkone;

public class Question5 
{
	public String mySubstring(String str, int idx)
	{
		if(idx < 0 || idx > str.length())
		{
			return "Index Out of Bounds error";
		}
		
		char[] toArray = new char[idx];
		
		for(int i = 0; i < toArray.length; i++)
		{
			toArray[i] = str.charAt(i);
		}
		
		return String.copyValueOf(toArray);
	}
}
