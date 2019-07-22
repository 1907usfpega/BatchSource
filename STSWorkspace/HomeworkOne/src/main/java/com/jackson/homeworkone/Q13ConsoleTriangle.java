package com.jackson.homeworkone;

public class Q13ConsoleTriangle 
{
	public String printTriangle(int h)
	{
		//declaring the height of our triangle
		int height = h-1;
		int printVal = 1;
		//out string output for testing
		String output = "";
		//loop through the lines
		for(int i = 0; i < height; i++)
		{
			//if we're at the start
			if(i == 0)
			{
				//add 0 to the output string, and println
				output += 0;
				System.out.println(output);
			}
			//if the printValue is 1
			if(printVal == 1)
			{
				//if the current line is even number
				if(i % 2 == 0)
				{
					//add 1 to the output string
					output = printVal + output;
				}
				//if the current line is odd
				else
				{
					//add 1 to the output string, and change printValue to 0
					output = output + printVal;
					printVal = 0;
				}
			}
			//if the printValue is 0
			else
			{
				//if the current line is an even number
				if(i % 2 == 0)
				{
					//add 0 to the output string
					output = printVal + output;
				}
				else
				{
					//add 0 to the output string, and change printValue to 1
					output = output + printVal;
					printVal = 1;
				}
			}
			//print the output
			System.out.println(output);
		}
		//return the output
		return output;
	}
}
