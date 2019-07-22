package com.jackson.homeworkone;

public class Q1BubbleSort 
{
	public int[] bubbleSort(int[] nums)
	{
		//int used for swapping
		int temp = 0;
		//loop through the whole list
		for(int i = 0; i < nums.length-1; i++)
		{
			//loop through the rest of the list from i
			for(int j = 0; j < nums.length-i-1; j++)
			{
				//if the number in the current index is greater than the number in the index to the right
				if(nums[j] > nums[j+1])
				{
					//swap em around, using the temp to hold the value while we swap
					temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
		}
		return nums;
	}
}
