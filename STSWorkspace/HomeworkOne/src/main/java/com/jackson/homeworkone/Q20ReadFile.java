package com.jackson.homeworkone;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q20ReadFile 
{
	public String readFromFile()
	{
		try
		{
			//System.getProperty("user.dir")+"\\src\\main\\java\\com\\jackson\\homeworkone\\Data.txt"
			//input file
			File file = new File("Data.txt");
			//use a scanner to read in the data from the file line by line
			Scanner sc = new Scanner(file);
			//return string
			String s = "";
			//while the scanner reads the next line
			while (sc.hasNextLine())
			{
				//split the line into a string array, using ":" as a delimmiter
				String[] line = sc.nextLine().split(":");
				//print out the line's text, formatted appropriatley
				System.out.print("Name: "+line[0]);
				System.out.println(" "+line[1]);
				System.out.println("Age: "+line[2]);
				System.out.println("State: "+line[3]+" State");
				//construct return string
				s += "Name: "+line[0]+" "+line[1]+"\nAge: "+line[2]+"\nState: "+line[3]+" State\n";
			}
			//close scanner and return string
			sc.close();
			return s;
		}
		catch(FileNotFoundException f)//exception thrown if we can't find the file
		{
			System.out.println("Couldn't find file");
		}
		//if we don't find the file, return a blank string
		return "";
	}
}