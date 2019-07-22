package com.revature.io;

import com.revature.beans.Person;

public class SerialDemo {

	public static void main(String[] args) {
		IO io = new IO();

		/*
		 * If output.txt does not exist, it will create it!
		 * If it doesn't exist, run it, and then refresh the project explorer to see it.
		 */
		
//		String a = "Bond, James Bond.";
//		io.writeOutputStreamContents(a + " War Eagle. Wegl wegl.");
		
		// Read from a file
//		System.out.println(io.readInputStreamContents());
		
//		Person p1 = new Person("Matt",573,4400);
//		Person p2 = new Person("Leo",24,110);
//		Person p3 = new Person("Brad",770,7000);
//		IOWithCollections.personList.add(p1);
//		IOWithCollections.personList.add(p2);
//		IOWithCollections.personList.add(p3);
		
		//IOWithCollections.writePersonFile();
		
		IOWithCollections.readPersonFile();
		System.out.println(IOWithCollections.personList.toString());
		
		
	}

}
