package com.revature.driver;
/*
 * Package declaration must be on first line
 * import-access things from other packages
 * 	not absolutely necessary
 * 
 * com.revature.beans.person mary = new person(....
 */
import com.revature.beans.Person;
	//Package- namespace in which to organize affiliated classes
	//Import- access stuff from another package
	//import static- this will only import static members
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
		Person yourPerson = new Person("Bart", 10, 80);
		Person hisPerson = new Person("Lisa", 8, 60);
		Person herPerson = new Person("Marge", 37, 120);
		Person theirPerson = new Person("Maggie", 1, 20);
		
		System.out.println(myPerson.toString());
		System.out.println(yourPerson.toString());
		System.out.println(hisPerson.toString());
		System.out.println(herPerson.toString());
		System.out.println(theirPerson.toString() + "\n");
		
		System.out.print("Goodbye, Earth!\n");
	}
}
