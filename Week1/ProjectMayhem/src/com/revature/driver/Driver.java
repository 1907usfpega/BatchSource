package com.revature.driver;
import com.revature.beans.Person;
	//Package- namespace in which to organize affiliated classes
public class Driver {
	//comment
	/*
	 * c
	 * o
	 * m
	 * m
	 * e
	 * n
	 * t
	 */
	//classes and projects-		Example
	//methods and variables-	exampleTwo
	//package names-			example.three
	//constants-				EXAMPLE_FOUR
	//main method- entry point
	
	public static void main(String []args) {
		/*
		 * public- can be accessed anywhere
		 * static- belongs to class, need not be instantiated
		 * String []args- parameters for this method
		 * protected- can be accessed by child classes
		 * private- can only be accessed by class
		 */
		
		Person myPerson = new Person("Homer", 39, Integer.MAX_VALUE);
		
		System.out.println(myPerson.toString() + "\n");
		
		System.out.print("Goodbye, Earth!\n");
	}
}
