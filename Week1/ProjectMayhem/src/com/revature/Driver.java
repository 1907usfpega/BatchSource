package com.revature;

import com.revature.beans.Person;

public class Driver {

	//single line comment
	/*
	 * long
	 * multiline
	 * comment
	 */

	/*
	 * Naming Connventions
	 * classes and projects- PascalCase- Capitalize each word
	 * Package names: all lowercase, separated by periods
	 * constants: ALL_CAPS_LOLZ
	 */

	//Main Method is the entry point
	
	public static void main(String[] args) {
		
		Person p = new Person("Deonta", 22, 120);
		System.out.println(p.toString());
		/*
		 * public - access modifiers, anything can see it
		 * static - belongs to class, does not need to be instantiated
		 * String[] args - parameter utilized in this method
		 */
		System.out.println("Goodbye, earth");
		
		/*
		 * Members of a class - can have different forms
		 * Instance variables - property that belongs to a specific object
		 * Static variables - belongs to class/ all instances 
		 * Instance methods-behavior related to a specific object
		 * Static methods- relative to the entire class
		 * Constructors-instantiates the class using the keyword "new"
		 */
	}

}
