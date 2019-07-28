package com.revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.revature.beans.Person;

public class IOWithCollections {
	private static final String personFile = "person.txt";
	public static ArrayList<Person> personList = new ArrayList<Person>();
	
	public static void writePersonFile() {
		ObjectOutputStream objectOut;
		try {
			objectOut = new ObjectOutputStream(new FileOutputStream(personFile));
			objectOut.writeObject(personList);
			objectOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@SuppressWarnings("unchecked")
	public static void readPersonFile() {		
		try {
			ObjectInputStream objIn = 
			new ObjectInputStream(new FileInputStream(personFile));
			personList = (ArrayList<Person>) objIn.readObject();
			objIn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
