package com.meschac.mafoula;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question20 {
	
	public String Question20() {
		Scanner fin = null; //init fin
		String fname = null;
		String lname = null;
		String age = null;
		String state = null;
		
		
		try {
			fin = new Scanner(new File("src/Data.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		fin.useDelimiter("[:, \n]"); //use colon & newline as delimiters; this method uses Regex so put in [] for character group
		fname = fin.next();
		lname = fin.next();
		age = fin.next();
		state = fin.next();
		fin.close(); //close file
		
		String returnValue = "Name: " + fname + " " + lname + "\nAge: " + age + " years\nState: " + state;
		System.out.println(returnValue);
		return returnValue;
	}
}


