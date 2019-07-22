package com.jackson.homeworkone;

public class Q2Fibonacci 
{
	public int fibonacci(int number)
	{
		//declaring our variables
		int n2 = 0;
		int n1 = 1;
		int temp = 0;
		//print out our initial values
		System.out.println(n2+"\n"+n1);
		//using number as our starting point, loop down until we hit 2
		for(int i = number; i>=2; i--)
		{
			//store n2 in temp
			temp = n2;
			//set n2 equal to n1
			n2 = n1;
			//increment n1 by temp
			n1 = n1 + temp;
			//print n1
			System.out.println(n1);
		}
		return n1;
	}
}
