package com.revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.revature.beans.Person;

public class IOwithCollections {
	private static final String PERSON_FILE = "person.txt";
	public static ArrayList<Person> personList = new ArrayList<Person>();

	public static void writePersonFile() {
		try {
			ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(PERSON_FILE));
			objectOut.writeObject(personList);
			objectOut.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// end writePersonFile

	public static void readPersonFile() {
		try {
			ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(PERSON_FILE));
			personList = (ArrayList<Person>) objectIn.readObject();
			objectIn.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}// end IOwithCollections
