package com.revature.hw1;

import java.util.ArrayList;

/*
 * Stores strings in an ArrayList and stores palindromes in 
 * a separate ArrayList.
 */

public class Q8 {
	
	public static ArrayList<String> palinParse(String[] strings)
	{
		ArrayList<String> stringList = new ArrayList<String>();
		ArrayList<String> palindromes = new ArrayList<String>();
		
		for (int i = 0 ; i < strings.length; i++)
		{
			stringList.add(strings[i]);
		}
		
		//Checks for palindromes.
		for (int i = 0; i < stringList.size(); i++)
		{
			String tar = stringList.get(i);
			if (tar.equals(Q3.stringInvert(tar)))
			{
				palindromes.add(tar);
			}
		}
		
		return palindromes;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
