package com.jackson.homeworkone;

import java.util.ArrayList;
import java.util.Collections;

public class Q19ArrayListFunctions 
{
	public void arraylistFunctions()
	{
		ArrayList<Integer> nums = new ArrayList<Integer>();
		int evenSum = 0;
		int oddSum = 0;
		System.out.println("Initial List: ");
		for(int i = 1; i <= 10; i++)
		{
			nums.add(i);
			if(i == 10)
			{
				System.out.print(i+"\n");
			}
			else
			{
				System.out.print(i+", ");
			}
		}
		for(int i = 0; i < nums.size(); i++)
		{
			if(nums.get(i) % 2 == 0)
			{
				evenSum += nums.get(i);
			}
			else
			{
				oddSum += nums.get(i);
			}
		}
		System.out.println("Sum of Even Numbers: " + evenSum);
		System.out.println("Sum of Odd Numbers: " + oddSum);
		for(int i = 0; i < nums.size(); i++)
		{
			//System.out.println(nums.get(i));
			if(isNumberPrime(nums.get(i)))
			{
				//System.out.println(nums.get(i)+" is prime");
				nums.remove(i);
				nums.add(i, new Integer(0));
			}
		}
		nums.removeAll(Collections.singleton(0));		
		System.out.println("List without Prime Numbers: ");
		for(int i = 0; i < nums.size(); i++)
		{
			if(i == nums.size()-1)
			{
				System.out.print(nums.get(i));
			}
			else
			{
				System.out.print(nums.get(i)+", ");
			}
		}System.out.println();
	}
	
	public static boolean isNumberPrime(Integer num)
	{
		/*if(num.equals(2))
		{
			System.out.println("dsfhs");
			return true;
		}*/
		
		/*for(int j = 2; j < num; j++)
	    {
			if(num % j == 0)
	        {
				return false;
	        }
	    }
		
		return true;*/
		if((num != 2 && num % 2 == 0) || num <= 1)
		{
			return false;
		}
		/*for(int j = 3; j*j<=num; j+=2)
		{
			if(num % j == 0)
			{
				return false;
			}
		}*/
		for(int j = 3; j < num; j++)
	    {
			if(num % j == 0 && num != j)
	        {
				return false;
	        }
	    }
		return true;
	}
}
