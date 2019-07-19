package com.jackson.homeworkone;

//
public class Q2Fibonacci 
{
	public int fibonacci(int number)
	{
		int n2 = 0;
		int n1 = 1;
		int temp = 0;
		System.out.println(n2+"\n"+n1);
		for(int i = number; i>=2; i--)
		{
			temp = n2;
			n2 = n1;
			n1 = n1 + temp;
			System.out.println(n1);
		}
		return n2 + n1;
	}
	
	public int fibRecursive(int n)
	{
		if(n == 1)
		{
			return 1;
		}
		return fibRecursive(n-1)+fibRecursive(n-2);
	}
	
	public static void main(String[] args)
	{
		Q2Fibonacci q2 = new Q2Fibonacci();
		System.out.println(q2.fibRecursive(25));;
	}
}
