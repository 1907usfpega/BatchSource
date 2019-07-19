package com.jackson.homeworkone;

public class Q13ConsoleTriangle 
{
	public void printTriangle(int h)
	{
		int height = h-1;
		int printVal = 1;
		String output = "";
		for(int i = 0; i < height; i++)
		{
			if(i == 0)
			{
				output += 0;
				System.out.println(output);
			}
			if(printVal == 1)
			{
				if(i % 2 == 0)
				{
					output = printVal + output;
				}
				else
				{
					output = output + printVal;
					printVal = 0;
				}
			}
			else
			{
				if(i % 2 == 0)
				{
					output = printVal + output;
				}
				else
				{
					output = output + printVal;
					printVal = 1;
				}
			}
			System.out.println(output);
		}
	}
}
