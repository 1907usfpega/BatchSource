package com.revature.hw1;

/*
 * Returns n factorial.
 */

public class Q4 {
	
	private static int result = 1;

	public static int nFactorial(int val)
	{
		
		for (int i = val; i > 1; i--)
		{
			result = result * i;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
