package com.revature.corejavaassignment;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.revature.beans.Person;

public class IOWithCollections {
	private static final String personFile = "person.txt";
	public static ArrayList<Person> personList
				= new ArrayList<Person>();
	
	public static void writePersonFile() {
		ObjectOutputStream objectOut;
		try {
			objectOut = new ObjectOutputStream(
					new FileOutputStream(personFile));
			objectOut.writeObject(personList);
			objectOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public IOWithCollections() {
		// TODO Auto-generated constructor stub
	}

}
