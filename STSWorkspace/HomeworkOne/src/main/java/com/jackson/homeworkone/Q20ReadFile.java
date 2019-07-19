package com.jackson.homeworkone;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q20ReadFile 
{
	public void readFromFile()
	{
		try
		{
			//System.out.println(System.getProperty("user.dir"));
			File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\jackson\\homeworkone\\Data.txt"); 
			Scanner sc = new Scanner(file);
			//sc.useDelimiter(":");
			while (sc.hasNextLine()) 
			{
				String[] line = sc.nextLine().split(":");
				System.out.print("Name: "+line[0]);
				System.out.println(" "+line[1]);
				System.out.println("Age: "+line[2]);
				System.out.println("State: "+line[3]+" State");
			}
			sc.close();
		}
		catch(FileNotFoundException f)
		{
			System.out.println("Couldn't find file");
		}
	}
}