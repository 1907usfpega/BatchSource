package com.revature.hw1;

import java.util.Date;

/*
 * Uses a switch to get the sqrt of a value, return the current date, or split a string into a string array.
 */

public class Q14 {
	
	public static void switcher(int i, double val)
	{
		switch (i)
		{
		case 1:
			System.out.println("SQRT of " + val + " = " + Math.sqrt(val));
			break;
			
		case 2:
			System.out.println(new Date());
			break;
			
		case 3:	
			String phrase = "I am learning core Java";
			String[] words = phrase.split(" ");
			for (int j = 0; j < words.length; j++)
			{
				System.out.println(words[j]);
			}
			break;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
