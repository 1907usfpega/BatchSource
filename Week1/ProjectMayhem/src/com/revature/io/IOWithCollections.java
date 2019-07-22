package com.revature.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.revature.beans.Person;

public class IOWithCollections {
	private static final String personFile = "Person.txt";
	public static ArrayList<Person> personList = new ArrayList<Person>();

	public static void writePersonFile() {
		ObjectOutputStream objectOut=
				new ObjectOutputStream (new FileOutputStream(personFile))
		objectOut.writeObject(personList);
		object.close();
	}
	
	public static void readPErson() {
		ObjectInputStream onjectIn= new ObjectInputStream(new FileInputStream(personFile));
		personList=(ArrayList<Person>)objectIn.readObject()objectIn;
		objectIn.close()objectIn;
	}
}
