package com.jackson.homeworkone;

import java.util.ArrayList;
import java.lang.StringBuilder;

public class Q8Palindromes 
{
	public ArrayList<String> savePalindromes(String ... list)
	{
		ArrayList<String> firstList = new ArrayList<String>();
		//add all of our strings to our arraylist
		for(int i = 0; i < list.length; i++)
		{
			firstList.add(list[i]);
		}
		//makea new list for the palindromes
		ArrayList<String> palList = new ArrayList<String>();
		for(int i = 0; i < firstList.size(); i++)
		{
			//if the current string is a palindrome
			if(isPalindrome(firstList.get(i)))
			{
				palList.add(firstList.get(i));
			}
		}
		return palList;
	}
	
	public static boolean isPalindrome(String input)
	{
		//variable for determining the middle of the string
		int middle = 0;
		//if the input length is an odd number
		if(input.length() % 2 != 0)
		{
			//we set the middle
			middle = (input.length()/2)+1;
			//create two substrings, one before the middle, one after the middle
			String s1 = input.substring(0, middle-1);
			String s2 = input.substring(middle);
			//reverse s2
			s2 = new StringBuilder(s2).reverse().toString();
			//if the reverse of s2 equals s1, we have a palindrome
			if(s1.equals(s2))
			{
				return true;
			}
		}
		//if the input length is an even number
		else if(input.length() % 2 == 0)
		{
			//set the middle
			middle = input.length()/2;
			//create two substrings, one before the middle, one after the middle
			String s1 = input.substring(0, middle);
			String s2 = input.substring(middle);
			//reverse s2
			s2 = new StringBuilder(s2).reverse().toString();
			//if the reverse of s2 equals s1, we have a palindrome
			if(s1.equals(s2))
			{
				return true;
			}
		}
		return false;
	}
}
