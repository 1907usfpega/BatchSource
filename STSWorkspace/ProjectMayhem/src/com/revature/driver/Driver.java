package com.revature.driver;

import com.revature.driver.beans.Person;

//packages are namespaces to organize related classes, interfaces, etc
public class Driver 
{
	//single line comment
	/*block comment
	 * 
	 * This
	 * is
	 * a
	 * really
	 * long
	 * multi
	 * line
	 * comment
	 * 
	 */
	
	/*
	 * naming conventions
	 * projects and classes: CapitolCase also Pascal case
	 * methods and variables: camelCase
	 * Package names: all lowercase, separated by periods
	 * constants: ALL_CAPS_NO_LOWERS
	 * 
	 */
	
	public static void main(String[] args)
	{
		//this is the entry point of the class
		
		/*
		 * Access modifiers
		 * Public: anything can access
		 * static: belongs to the class (not the object), and does not need to be instantiated
		 * String[] args: a parameter utilized in this methods  
		 */
		System.out.println("Goodbye, cruel world!\n");
		
		Person a = new Person("Matt", 33, 270);
		Person b = new Person("Jackson", 56, 199);
		Person c = new Person("Hann", 12, 1728);
		Person d = new Person("Deonta", 128, 10);
		Person e = new Person("Andrew", 22, -11);
		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(c.toString());
		System.out.println(d.toString());
		System.out.println(e.toString());
	}

}
