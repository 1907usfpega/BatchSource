package io;

import day2.pt1.Person;

public class serialDemo {

	public static void main(String[] args) {
		IO io = new IO();
		
		//if output.txt does not exist. it will create it
		//if it doesn't exist, run it, and then REFRESH THE PROJECT (right-click) to see it
		String bond = "James Bond";
		io.writeOutputStringContents(bond);
		
		
		//Read from file
		System.out.println(io.readInputStreamContents());
		
		
//------------------------------------IO Collections-------------------------------------------
		Person p1 = new Person("Lisa", 72, 120);
		Person p2 = new Person("Patrick", 44, 189);
		Person p3 = new Person("Natalie", 13, 78);
		
		IOCollections.personList.add(p1);
		IOCollections.personList.add(p2);
		IOCollections.personList.add(p3);
		
		IOCollections.writePersonFile();
		
		IOCollections.readPersonFile();
		System.out.println(IOCollections.personList.toString());
		
	}
}
