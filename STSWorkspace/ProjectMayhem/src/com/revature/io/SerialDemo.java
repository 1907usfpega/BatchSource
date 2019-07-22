package com.revature.io;

import com.revature.driver.beans.Person;

public class SerialDemo 
{
	public static void main(String[] args) 
	{
		IO io = new IO();
		/*
		 * if output.txt doesnt exist, it'l be created
		 * after it runs, refresh the project explorer to see it
		 */
		//String a = "Bond, James Bond.";
		//io.writeOutputStreamContents(a+" Roll Tide, Goldfinger");
		//System.out.println(io.readStringInputContents());
		/*Person p1 = new Person("Matt", 573, 4400);
		Person p2 = new Person("Leo", 24, 110);
		Person p3 = new Person("B-Rad", 770, 7000);
		IOWithCollections.people.add(p1);
		IOWithCollections.people.add(p2);
		IOWithCollections.people.add(p3);*/
		//IOWithCollections.writePersonFile();
		IOWithCollections.readPersonFile();
		System.out.println(IOWithCollections.people.toString());
	}

}
