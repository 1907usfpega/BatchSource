package com.jackson.homeworkone;

public class Q18ChildClass extends Q18AbstractClass 
{

	@Override
	public boolean checkUppercase(String input)
	{
		//creating some base char a
		char current = 'a';
		for(int i = 0; i < input.length(); i++)
		{
			//assigning the current char in the loop to current
			current = input.charAt(i);
			//if the ASCII code of our char is within the range of uppercase letters
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
		//creating some base char a
		char current = 'a';
		//making a char array from string input
		char[] chars = input.toCharArray();
		for(int i = 0; i < chars.length; i++)
		{
			//assigning the current char in the loop to current
			current = chars[i];
			//if current is within the range of lowercase letters
			if((int)current >= 97 && (int)current <= 122)
			{
				//change the char to an uppercase letter
				String temp = String.valueOf(chars[i]).toUpperCase();
				//assign it to the current index i in the array
				chars[i] = temp.charAt(0);
			}
		}
		//reform the char array into a string
		String output = new String(chars);
		return output;
	}

	@Override
	public Integer addTen(String input)
	{
		//parse the input string into an Integer object
		Integer num = Integer.parseInt(input);
		//return num after adding 10 to its value
		return num + 10;
	}
	
}
