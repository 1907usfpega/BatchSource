package com.jackson.homeworkone;

import java.util.ArrayList;

public class Q9PrimeNums 
{
	public ArrayList<Integer> findPrimes()
	{
		//declaring our list
		ArrayList<Integer> nums = new ArrayList<Integer>();
		//add all natural numbers
		for(int i = 1; i <= 100; i++)
		{
			nums.add(new Integer(i));
		}
		//make a new list to hold the prime numbers
		ArrayList<Integer> primes = new ArrayList<Integer>();
		//loop through the list 
		for(int i = 0; i < 100; i++)
		{
			//grab the int num from the full list and check if it's prime
			Integer num = nums.get(i);
			if(isPrime(num))
			{
				//if it's prime, we add it to the list
				primes.add(num);
			}
		}
		return primes;
	}
	
	public static boolean isPrime(int num)
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
