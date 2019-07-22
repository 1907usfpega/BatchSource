package com.revature.io;

import com.revature.beans.Person;

public class SerialDemo {

	public static void main(String[] args) {
		IO io = new IO();
		/* if output.txt does not exist, this will create it
		 * if it doesn't exist, run it, and then refresh the project explorer to see it
		 */
		
		/*
		 * String a = "Bond, James Bond."; io.writeOutputStreamContents(a+" blep.");
		 * 
		 * System.out.println(io.readInputStreamContents());
		 */
		
		/*
		 * Person p1 = new Person("Matt",573,4400); Person p2 = new
		 * Person("Leo",24,110); Person p3 = new Person("Brad",770,7000);
		 * IOwithCollections.personList.add(p1); IOwithCollections.personList.add(p2);
		 * IOwithCollections.personList.add(p3);
		 * 
		 * IOwithCollections.writePersonFile();
		 */

		IOwithCollections.readPersonFile();
		System.out.println(IOwithCollections.personList.toString());
	}//end main

}//end SerialDemo
