package com.revature.driver;

import com.revature.beans.Person;

//package- namespace to organize related class/interfaces,etc
public class Driver {
	//single line comment
	/*
	 * This
	 * is
	 * a 
	 * really
	 * long
	 * multi
	 * line
	 * comment
	 */
	/*
	 * Naming Conventions
	 * classes and projects-Pascal- Capitialize each word
	 * methods and variables- camelCase ex firstSecondThird
	 *Package names: all lowercase, separated by periods
	 *constants: ALL_CAPS_LOLZ
	 * 
	 */
	//Main Method is the entry point
	public static void main(String[] args) {
		
		Person a =new Person("Matt",33,270);
		Person b =new Person("Jackson",56,199);
		Person c =new Person("Hann",12,1728);
		Person d =new Person("Deonta",128,10);
		Person e =new Person("Andrew",22,-11);
		System.out.println(a.toString());
		/*
		 * public- access modifiers, anything can see it
		 * static- belongs to class, does not need to be instantiated
		 * String []args- parameter utilized in this method
		 */
		System.out.println("Goodbye,earth");
		/*
		 * Members of a class- can have different forms
		 * Instance variables- property that belongs to a specific object
		 * Static variables-belongs to class/all instances
		 * Instance methods-behavior related to a specific object
		 * Static methods- relative to the entire class
		 * Constructors-instantiates the class using the keyword "new"
		 */
	}
}
