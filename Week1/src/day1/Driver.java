package day1; //package is an organized name space for related classes, interfaces, etc.

import day2.pt1.Person;
import day3.pt2.NegativeNumberException;

public class Driver {
	
	/*
	 * Naming Conventions
	 * package names: all lowercase, separated by periods
	 * classes & projects: Capitalize each word
	 * methods and variables: camelCase
	 * constants: ALL_UPPERCASE
	 */
	
	public static void main(String[] args) { //Main method for program to run
		
		/*
		 * public: access modifier that allows everything to see it
		 * static: belongs to class, does not need to be instantiated
		 * String[] args: parameters utilized by this method
		 */
		
		System.out.println("Toodaloo Planet");
		
		String s1 = "n";
		//s1 = "m";
		//s1 += "o"; 
		System.out.println(s1);
		
		
		
		/*
		 * Members of a class can have different forms
		 * Instance Variables: property that belongs to a specific object
		 * Static Variables: belongs to class/all instances
		 * Instance Methods: behavior relayed to a specific object
		 * Static Methods: relative to the entire class
		 * Constructors: instantiates the class using the keyword "new"
		 */
		
		Person guy = new Person("Tyler", 33, 157); //Create person object from Day2 package
		//Passed in all args (name, age, weight)  //Import package.class (right click)
		
		System.out.println(guy.toString());		//toString() is our print statement in Person.java	 
		
		Person lady = new Person("Jane", 24, 123); //Also prints code blocks
		System.out.println(lady.toString());	  //Static only prints once, runs before Person constructor
		
		System.out.println(guy.getAge());
		try{
			guy.increaseAge(-4);
		}catch (NegativeNumberException e) {
			e.printStackTrace();
		}
		
		
		
	}//end main

	
}//end class Driver
