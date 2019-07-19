package com.jackson.homeworkone;

public class Q12EvenNums 
{
	public void evenNums()
	{
		int[] nums = new int[100];
		for(int i = 0; i < 100; i++)
		{
			nums[i] = i+1;
		}
		
		for(int i : nums)
		{
			if(i % 2 == 0)
			{
				System.out.println(i);
			}
		}
	}
}
