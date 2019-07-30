package com.revature.assignment1;

import java.util.ArrayList;

/**
 * Assignment #1 Question 20
 *Create a notepad file called Data.txt and enter the following:
 *Mickey:Mouse:35:Arizona
 *Hulk:Hogan:50:Virginia
 *Roger:Rabbit:22:California
 *Wonder:Woman:18:Montana
 *Write a program that would read from the file and print it out to the screen in the following
 *format:
 *Name: Mickey Mouse
 *Age: 35 years
 *State: Arizona State
 * 
 * @author Kyle Kolstad
 *
 * 
 */
public class IOReadAndPrint {
	
	private static int count = 0;
	private ArrayList<String> firstName = new ArrayList<String>(); 
	private ArrayList<String> lastName = new ArrayList<String>(); 
	private ArrayList<Integer> age = new ArrayList<Integer>(); 
	private ArrayList<String> state = new ArrayList<String>();
	
	
	/**
	 * Default Constructor
	 */
	public IOReadAndPrint() {
		
	}
	
	public void readTextFile(String firstName, String lastName, int age, String state) {
		this.firstName.add(firstName);
		this.lastName.add(lastName);
		this.age.add(age);
		this.state.add(state);
		count++;
	}
	
	public void printContents() {
		
		for(int i = 0; i < count; i++) {
			System.out.println("----------------------------------");
			System.out.println("Name: " + firstName.get(i) + " " + lastName.get(i));
			System.out.println("Age: " + age.get(i) + " years old");
			System.out.println("State: " + state.get(i) + " State");
			System.out.println("----------------------------------");
		}
		
	}
}
