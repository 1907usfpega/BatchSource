package com.jackson.homeworkone;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Q14SwitchCase 
{
	public void switchExample(int choice)
	{
		switch(choice)
		{
			case 1:
				squareRoot();
				break;
			case 2:
				displayDate();
				break;
			case 3:
				splitString();
				break;
			default:
				System.out.println("That is not a valid input");
				break;	
		}
	}
	public static void squareRoot()
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter a number: ");
		double d = s.nextDouble();
		d = Math.sqrt(d);
		System.out.println("Square Root: "+d);
		s.close();
	}
	
	public static void displayDate()
	{
		Date current = new Date();
		System.out.printf("%s %tB %<te, %<tY", "Current Date: ", current);
		//System.out.println("The current date is: "+current);
	}
	
	public static void splitString()
	{
		String str = "I am learning Core Java";
		String[] splitVer = str.split("");
		System.out.println(Arrays.toString(splitVer));
	}
}
