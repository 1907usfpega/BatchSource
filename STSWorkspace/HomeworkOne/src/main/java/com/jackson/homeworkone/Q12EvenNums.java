package com.jackson.homeworkone;

public class Q12EvenNums 
{
	public int[] evenNums()
	{
		//make two arrays, one for all natural numbers 1-100, and one for all even numbers 1-100
		int[] nums = new int[100];
		int[] numsEven = new int[50];
		//loop through 0-99
		for(int i = 0; i < 100; i++)
		{
			//set position i in nums[] to be equal to i+1
			nums[i] = i+1;
			//if the number i+1 is evenly divisible by 2
			if((i+1) % 2 == 0)
			{
				//add it to the position i/2 in the array of even numbers
				numsEven[i/2] = i+1;
			}
		}
		for(int i : numsEven)
		{
			//print out all the numbers in numsEven
			System.out.println(i);
		}
		return numsEven;
	}
}
