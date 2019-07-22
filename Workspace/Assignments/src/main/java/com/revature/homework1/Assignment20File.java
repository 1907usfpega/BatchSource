package com.revature.homework1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Assignment20File {
	public String readMyFile(){
		try {
			File file = new File("MyDocument");
			Scanner input = new Scanner(file);
			String s = "";
			while(input.hasNextLine())
			{
				String[] line = input.nextLine().split(":");
				
				
			s += "Name: "+ line[0]+ " "+line[1]+"\nAge "+ line[2]+ "\nState: " +line[3]+" State\n";

			}
			input.close();
			return s;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Could not find file ");
			e.printStackTrace();
		}
			return "";
		
	}

}
