package com.revature.io;

import com.revature.beans.Person;

public class SerialDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IO io = new IO();
		String a = "Bond, James Bond";
		
		//io.writeOutputStreamContents(a + "RollTide");
		//refresh F5
		//System.out.println(io.readInputStreamContents());
		
		  Person p1 = new Person("Matt", 573, 4400); Person p2 = new Person("Matt",
		  573, 4400); Person p3 = new Person("Matt", 573, 4400);
		  
		  IOWithCollections.personList.add(p1); IOWithCollections.personList.add(p2);
		  IOWithCollections.personList.add(p3);
		 
		
		  IOWithCollections.readPersonFile();
		  System.out.println(IOWithCollections.personList.toString());
		 
		  //IOWithCollections.writePersonFile();
	}

}
