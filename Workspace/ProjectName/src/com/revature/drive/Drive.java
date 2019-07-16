package com.revature.drive;

import com.revature.beans.Person;

public class Drive {
// namespace to organize related classesäüö
/*
 * comment here~~
 * 
  OR HERE
 */
	/*
	 * naming conventions
	 * Classes & projects are capitalized (Pascal casing)
	 * 
	 * methods and variables - camelCase
	 * packagenames all lowercase, sperated by periods
	 * Constants - ALL_CAPS_DAD
	 */
	//Mainmethod is the ENTRYPOINT
	public static void main(String[] ogre) {
		/*
		 * public - everyone can see it (access motifier)
		 * static - cannot be changed, can be accessed without 
		 * instantiation; belongs to the class
		 * 	String[] args - parameter utilized in this method
		 */
		Person a = new Person("Leo", 23, 70);
		Person c = new Person("Lea", 223, 0);
		Person b = new Person("Leu", 231, 370);
		System.out.println(a.toString());
		System.out.println("KTHXBYE");	
	}
}
