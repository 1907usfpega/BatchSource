package com.revature.hw1;

/*
 * Stores #s 1-100 in an array, then uses enhanced FOR loop to print out even values.
 */

public class Q12 {
	
	public static void enhancedLoopEvens(int[] a)
	{
		System.out.println("The following values are even: ");
		for(int i:a)
		{
			if (Q6.evenFlow(a[i]) == true)
			{
				System.out.print(a[i] + " ");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
