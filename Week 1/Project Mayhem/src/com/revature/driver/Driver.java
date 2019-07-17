package com.revature.driver;
/*
 * Package declaration must be on the first line
 * import-access things from other packages
 * BUT they are not absolutely necessary - could use fully qualified class name
 * com.revature.beans.Person mary = new Person();
 * We use the fully qualified class name for when we are using classes with the same name from different packages
 * import static ... - this will only import static members
 * import all the things!! import com.revature.coolstuff.* <--- it is the * that grabs everything
 */

import com.revature.beans.Person;
import com.revature.exceptions.increaseByNegativeNumberExcpetion;

//package: a namespace to organized a related classes/interfaces, etc
public class Driver {
	// Single line comment
	/*
	 * Block 
	 * Comment
	 */
	/*
	 * Naming Conventions
	 * Classes and Projects:Pascal: Capitalize each word
	 * methods and variables: camelCase ex: firstSecoundThird
	 * package: all lower case, separated by periods
	 * constants: ALL_CAPS
	 */
	//Main methods is the entry point
	public static void main(String[] args) {
		Person a = new Person("Matt", 33, 269);
		Person b = new Person("Jackson", 56, 199);
		Person c = new Person("Hann", 12, 1728);
		Person d = new Person("Deanta", 128, 10);
		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(c.toString());
		System.out.println(d.toString());
		System.out.println("Age before " + c.getAge());
		try {
			c.increaseAgeby(-4);
		} catch (increaseByNegativeNumberExcpetion i) {
			System.out.println("You can't decrease yoru age boi");
		}
		System.out.println("Age after " + c.getAge());
		/*
		 * public: access modifier, anything can see it
		 * static: belongs to the class, does not need to be instantiated
		 * String[] args: parameter utilized in this methods
		 */
		System.out.println("Dab on the haters!");
		/*
		 * Members of a class: 	can have different forms
		 * Instance variables: 	property that belongs to the specific object
		 * Static variables: 	belongs to the class/all instances
		 * Instance methods: 	behavior related to a specific object
		 * Static methods: 		relative to the entire class
		 * Constructors: 		instantiates the class using the keyword "new"
		 */
	}
}