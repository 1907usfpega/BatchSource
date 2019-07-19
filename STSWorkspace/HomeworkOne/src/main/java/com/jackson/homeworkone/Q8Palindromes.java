package com.jackson.homeworkone;

import java.util.ArrayList;
import java.lang.StringBuilder;

public class Q8Palindromes 
{
	public ArrayList<String> savePalindromes(String ... list)
	{
		ArrayList<String> firstList = new ArrayList<String>();
		for(int i = 0; i < list.length; i++)
		{
			firstList.add(list[i]);
		}
		
		ArrayList<String> palList = new ArrayList<String>();
		for(int i = 0; i < firstList.size(); i++)
		{
			if(isPalindrome(firstList.get(i)))
			{
				palList.add(firstList.get(i));
			}
		}
		return palList;
	}
	
	public static boolean isPalindrome(String input)
	{
		int middle = 0;
		if(input.length() % 2 != 0)
		{
			middle = (input.length()/2)+1;
			String s1 = input.substring(0, middle-1);
			String s2 = input.substring(middle);
			s2 = new StringBuilder(s2).reverse().toString();
			if(s1.equals(s2))
			{
				return true;
			}
		}
		else if(input.length() % 2 == 0)
		{
			middle = input.length()/2;
			String s1 = input.substring(0, middle);
			String s2 = input.substring(middle);
			s2 = new StringBuilder(s2).reverse().toString();
			if(s1.equals(s2))
			{
				return true;
			}
		}
		return false;
	}
}
