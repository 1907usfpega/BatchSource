package com.revature.driver;
import com.revature.beans.Person;

//package: namespace to organise related classes/interfaces
public class Driver {
	//single line comment
	
	/* this is
	 * still a
	 * comment
	 */
	
	/* naming convention
	 * class and project: Pascal ex Capitalize Each Word
	 * method and variable: camelCase ex firstSecondThird
	 * package names: all lowercase separated.by.periods
	 * constants: ALL_CAPS_W_UNDERSCORES
	 */
	
	//main is the start
	public static void main(String[] args) {
		/*
		 * public: access modifier
		 * static: belongs to class not object, doesn't need to be instantiated
		 * string[] args: parameter
		 */
		System.out.println("Hewwo? Mistew Obama?");
		Person a = new Person ("Mark Hammel", 45, 230);
		Person b = new Person ("Carrie Fisher", 12, 145);
		
		System.out.println(b.toString());
		
		b.increaseAgeBy(-4);
		
		System.out.println(b.toString());
		System.out.println(a.toString());
		
		
	}
}
