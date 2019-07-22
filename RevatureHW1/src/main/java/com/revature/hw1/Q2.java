package com.revature.hw1;
/*
 * Class that returns the first 25 numbers of the Fibonacci sequence.
 */

import java.util.ArrayList;

public class Q2 {

	public static ArrayList<Integer> fibonacci()
	{
		ArrayList<Integer> fib = new ArrayList<Integer>();
		fib.add(0);
		fib.add(1);
		for (int i = 1; i < 25; i++)
		{
			fib.add(fib.get(i) + fib.get(i-1));
		}
		return fib;
	}
}
