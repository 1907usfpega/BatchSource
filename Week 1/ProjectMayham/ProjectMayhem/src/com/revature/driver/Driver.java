package com.revature.driver;
/*
 * Package declaration must be on the same line.
 * import-access things from other packages.
 * not absolutely necessary - could use fully qualified class name
 * com.revature.beans.Person mary = new com.revature.beans.Person.Person
 */
import com.revature.beans.Person;

/*
 * import static ... - this will only import static members
 * import all the things!! - import com.revature.coolstuff.*
 */

public class Driver {

	
	/*
	 * Naming Conventions
	 * Classes and projects - pascal - Capitalize each word
	 * metyhods and variables - camelCase
	 * Package names - all lowercase, seperated by periods
	 * constants - ALL_CAPS_LOLZ
	 */
	public static void main(String[] args) {

		Person a = new Person("Matt",33,270);
		Person b = new Person("Jackson",56,199);
		Person c = new Person("Hann",12,1728);
		Person d = new Person("Deonta",128,10);
		Person e = new Person("Andrew",22,-11);
		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(c.toString());
		System.out.println(d.toString());
		System.out.println(e.toString());
		
		/*
		 * public - access modifiers, anything can see it
		 * static - belongs to class, does not need to be instantiated
		 * String [] args - parameter utilized in this method
		 */
		
		System.out.println("Goodbye Earth!");
		
		/*
		 * Members of a class - can have different forms
		 * Instance variables - property that belongs to a specific object
		 * Static variables - belongs to class/all instances
		 * Instance methods - behavior related to a specific object
		 * Static methods - relative to the entire class
		 * Constructors - instantiates the class using the keyword "new"
		 */	
	
		
		
	}

}
