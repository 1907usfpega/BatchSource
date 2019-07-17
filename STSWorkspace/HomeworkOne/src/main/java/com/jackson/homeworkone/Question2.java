package com.jackson.homeworkone;

//
public class Question2 
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
}
