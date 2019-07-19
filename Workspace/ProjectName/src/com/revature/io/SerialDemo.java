package com.revature.io;

import com.revature.beans.Person;

public class SerialDemo {
	public static void main(String[] args) {
		IO io = new IO();
		/*
		 * String a= "Bond, James Bond"; io.writeOutputStreamContents(a+ " Roll Tide");
		 */
		//System.out.println(io.readInputStreamContents());
		Person p1 = new Person("Matt", 123, 123);
		Person p3 = new Person("Msatt", 23, 13);
		Person p2 = new Person("Mdatt", 3, 23);

		IOWithCollections.personList.add(p1);
		IOWithCollections.personList.add(p2);
		IOWithCollections.personList.add(p3);
		//IOWithCollections.writePersonFile();
		IOWithCollections.readPersonFile();
		System.out.println(IOWithCollections.personList.toString());
		
	}
}
