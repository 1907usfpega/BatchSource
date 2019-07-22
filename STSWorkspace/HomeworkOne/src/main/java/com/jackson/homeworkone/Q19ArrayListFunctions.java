package com.jackson.homeworkone;

import java.util.ArrayList;
import java.util.Collections;

public class Q19ArrayListFunctions 
{
	public void arraylistFunctions()
	{
		//declaring our variables
		ArrayList<Integer> nums = new ArrayList<Integer>();
		int evenSum = 0;
		int oddSum = 0;
		System.out.print("Initial List: ");
		//loop to print out each number and add them to our initial arraylist
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
		//loop through nums and add each value either to evenSum or oddSum
		for(int i = 0; i < nums.size(); i++)
		{
			//if the current int is divisible by 2
			if(nums.get(i) % 2 == 0)
			{
				evenSum += nums.get(i);
			}
			else
			{
				oddSum += nums.get(i);
			}
		}
		//print out both sums
		System.out.println("Sum of Even Numbers: " + evenSum);
		System.out.println("Sum of Odd Numbers: " + oddSum);
		//
		for(int i = 0; i < nums.size(); i++)
		{
			if(isNumberPrime(nums.get(i)))
			{
				nums.remove(i);
				nums.add(i, new Integer(0));
			}
		}
		//sort the list
		nums.removeAll(Collections.singleton(0));		
		//print out the list of primes
		System.out.print("List without Prime Numbers: ");
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
		//if our number is not equal to 2, and is divisible by two, OR if it's less than or equal to 1
		if((num != 2 && num % 2 == 0) || num <= 1)
		{
			return false;
		}
		//loop through until we hit num
		for(int j = 3; j < num; j++)
	    {
			//if we are divisible by j and num is not equal to j
			if(num % j == 0 && num != j)
	        {
				return false;
	        }
	    }
		return true;
	}
}
