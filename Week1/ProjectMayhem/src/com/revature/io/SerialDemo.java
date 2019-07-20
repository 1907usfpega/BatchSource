package com.revature.io;

import com.revature.beans.Person;
import com.revature.corejavaassignment.IOWithCollections;

public class SerialDemo {

	public SerialDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*IO io = new IO();
		String a = "Bond, James Bond.";
		io.writeOutputStreamContents(a + "Roll Tide");
		System.out.println(io.readInputStreamContents());*/
		Person p1 = new Person("Matt", 573, 4400);
		Person p2 = new Person("Leo", 24, 110);
		Person p3 = new Person("Brad", 770,7000);
		IOWithCollections.personList.add(p1);
		IOWithCollections.personList.add(p2);
		IOWithCollections.personList.add(p3);
		
	}

}
