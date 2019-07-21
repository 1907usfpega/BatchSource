package com.revature.questions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*Create a notepad file called Data.txt and enter the following:
 
Mickey:Mouse:35:Arizona
Hulk:Hogan:50:Virginia
Roger:Rabbit:22:California
Wonder:Woman:18:Montana

Write a program that would read from the file and print it out to 
the screen in the following format:

Name: Mickey Mouse
Age: 35 years
State: Arizona State

*/
public class Q20 {
	private static final String myFile = "src/main/java/com/revature/files/Data.txt";
	private static BufferedReader reader;
	private static String line = "";

	public static void readAll() {
		startReader();
		line = readLine();
		// iterate inside the file
		while (line != null) {

			//read each line and load Object Character
			String array[] = line.split(":");
			FicCharacter character = new FicCharacter(array[0], array[1], array[2], array[3]);
			System.out.println(character.toString() + "\n");

			line = readLine();
		}
	}

	// read next line
	private static String readLine() {
		try {
			line = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return line;
	}

	// intanciate a buffer to read file
	private static void startReader() {
		try {
			reader = new BufferedReader(new FileReader(myFile));
			// catch errors
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

//Create a entity to receive data
class FicCharacter {
	private String firstName;
	private String lastName;
	private String state;
	private String age;

	protected FicCharacter(String firstName, String lastName, String age, String state) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.state = state;
		this.age = age;
	}

	// print on given format
	@Override
	public String toString() {
		return "Name:  " + firstName + " " + lastName + "\nAge: " + age + " years" + "\nState: " + state + " State";
	}

}