package com.revature.questions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Question20 {
	public static final File file = new File("src/main/resources/inputData.txt");
	static ArrayList<Person> persons = new ArrayList<Person>();

	public static boolean doTask() {			//Readies to open the file

		System.out.println(file);
		FileInputStream is = null;
		try {
			System.out.println(file);
			is = new FileInputStream(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int b = 0;
		try {
			interpretBytestream(is, b);				//File-reading starts here - is closed when finished.
			is.close();
		} catch (IOException e) {
			e.printStackTrace();

		}
		for (Person person : persons) {		//persons were created in interpretBytestream()
			System.out.println("Name: " + person.firstName + " " + person.lastName);
			System.out.println("Age: " + person.age);
			System.out.println("State: " + person.location);
			
		}
		return file.exists();
	}

	
	//reads through the inputStream and appends to a string. in case of a colon or \n-char, changes the variable that string is written into.
	//every newline, or at the end of reading, the current personObject will be saved into a PersonArrayList and the reset, to be overwritten 
	//by the next line.
	public static ArrayList<Person> interpretBytestream(FileInputStream is, int b) throws IOException {
		Person person = new Person();
		int currentState = 0;
		StringBuilder str = new StringBuilder();
		char c;
		while ((b = is.read()) != -1) {
			System.out.println((char)b);
			switch (c = (char) b) {
			case (':'):													// in case of a char being a colon, a new variable is being written into.
				switch (currentState) {
				case (0):									
					currentState = 1;
					person.firstName = str.toString();
					str.delete(0, str.length());
					break;
				case (1):
					currentState = 2;
					person.lastName = str.toString();
					str.delete(0, str.length());
					break;
				case (2):
					currentState = 0;
					person.age = str.toString();
					str.delete(0, str.length());
					break;
				} break;
			case ('\n'):
				person.location = str.toString();
				str.delete(0, str.length());
				persons.add(person);
				person = new Person();
				break;
			default:
				str.append(c);
			}
		}
		if(b==-1) {
		person.location = str.toString();
		str.delete(0, str.length());
		persons.add(person);
		}
		return persons;
	}
}

class Person {
	public String firstName;
	public String lastName;
	public String age;
	public String location;

	public Person(String firstName, String lastName, String age, String location) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.location = location;
	}

	public Person() {

	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", location=" + location
				+ "]";
	}
}