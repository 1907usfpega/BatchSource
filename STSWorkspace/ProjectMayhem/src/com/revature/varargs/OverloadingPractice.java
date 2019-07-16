package com.revature.varargs;

public class OverloadingPractice 
{
	
	//public int a, b;
	//public float c, d;
	//public Integer e, f;
	
	public OverloadingPractice()
	{
		
	}
	
	public static int add(int one, int two)
	{
		return one+two;
	}
	
	public static double add(double one, double two)
	{
		return one+two;
	}
	
	public static  int fromFloatToInt(float one)
	{
		return (int)one;
	}
	
	public static int sum(int ... v)
	{
		int sum = 0;
		for(int i : v)
		{
			sum += i;
		}
		return sum;
	}
	
	public static void main(String[] args) 
	{
		int a = 5;
		int b = 29;
		float c = 34;
		float d = 111;
		Integer e = 15;
		Integer f = 8;
		
		//1. Exact match
		System.out.println("Add method with ints: "+add(a, b));
		System.out.println("Add method with floats: "+add(c, d));
		
		//2. Conversion
		System.out.println("Converting from float to int: "+fromFloatToInt(c));
		
		//3. Autoboxing/autounboxing
		System.out.println("Autounboxing from Integer to int: "+add(e, f));
		
		//4. VarArgs
		System.out.println("Summation method using VarArgs: "+sum(1, 3435, 67, 78, 345, 78));
	}

}
