package com.revature.hw1;

/*
 * Reverses a string without using StringBuffer.
 */

public class Q3 {
	
	public static String stringInvert(String a)
	{
		String result = new String();
		for(int i = a.length()-1; i >= 0; i--)
		{
			char letter = a.charAt(i);
			result = result + letter;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
