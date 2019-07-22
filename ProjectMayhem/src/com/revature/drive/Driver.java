package com.revature.drive;

import com.revature.beans.Person;

public class Driver {
	//single line comment
	
	/*
	 * multi
	 * line
	 * comment
	 */
	
	/*
	 * naming conventions:
	 * Classes and projects: Pascal Case: CapitalizeEachWord
	 * Methods and variables: camelCase: lowercaseFirstThenCapitalizeEachWord
	 * Package name: all.lowercase.separated.by.periods
	 * constants: ALL_CAPS
	 */
	//Main method is entry point
	public static void main(String[] args) {
		
		/* public: anything can see it
		 * static: belongs to class, does not need to be instantiated
		 * String[] args: parameter utilized in this method
		 */
		System.out.println("blep");
		
		Person a = new Person("Matt",33,270);
		Person b = new Person("Jackson",56,199);
		Person c = new Person("Hann",12,1728);
		Person d = new Person("Deonta",128,10);
		Person e = new Person("Andrew",22,-11);
		Person f = new Person("Ren",420,69);
		/*
		 * System.out.println(a.toString()); System.out.println(b.toString());
		 * System.out.println(c.toString()); System.out.println(d.toString());
		 * System.out.println(e.toString()); System.out.println(f.toString());
		 */
		System.out.println(c.getAge());
		c.increaseAgeBy(-4);
		System.out.println(c.getAge());
		
	}
}
