package com.jackson.homeworkone;

public class Q18ChildClass extends Q18AbstractClass 
{

	@Override
	public boolean checkUppercase(String input) 
	{
		char current = 'a';
		for(int i = 0; i < input.length(); i++)
		{
			current = input.charAt(i);
			if((int)current >= 65 && (int)current >= 90)
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public String lowerToUpper(String input) 
	{
		char current = 'a';
		char[] chars = input.toCharArray();
		for(int i = 0; i < chars.length; i++)
		{
			current = chars[i];
			if((int)current >= 97 && (int)current <= 122)
			{
				String temp = String.valueOf(chars[i]).toUpperCase();
				chars[i] = temp.charAt(0);
			}
		}
		String output = new String(chars);
		return output;
	}

	@Override
	public Integer addTen(String input) 
	{
		Integer num = Integer.parseInt(input);
		return num + 10;
	}
	
}
