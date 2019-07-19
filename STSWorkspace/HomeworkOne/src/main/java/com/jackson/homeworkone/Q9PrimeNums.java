package com.jackson.homeworkone;

import java.util.ArrayList;

public class Q9PrimeNums 
{
	public ArrayList<Integer> findPrimes()
	{
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i = 1; i <= 100; i++)
		{
			nums.add(new Integer(i));
		}
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for(int i = 0; i < 100; i++)
		{
			/*if(nums.get(i) % 2 != 0 && nums.get(i) % 3 != 0 && nums.get(i) % 5 != 0 && nums.get(i) % 7 != 0)
			{
				primes.add(nums.get(i));
			}*/
			Integer num = nums.get(i);
			if(isPrime(num))
			{
				primes.add(num);
			}
		}
		return primes;
	}
	
	public static boolean isPrime(int num)
	{
		if(num == 2)
		{
			return true;
		}
		if(num % 2 == 0 || num == 0 || num == 1)
		{
			return false;
		}
		for(int j = 3; j*j<=num; j+=2)
		{
			if(num % j == 0)
			{
				return false;
			}
		}
		return true;
	}
}
