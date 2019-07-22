package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import day2.pt1.Person;

public class IOCollections {

	private static final String personFile = "person.txt";
	public static ArrayList<Person> personList = new ArrayList<Person>();
	
	public static void writePersonFile() {
		
		ObjectOutputStream objectOut;
		try {
			objectOut = new ObjectOutputStream(new FileOutputStream(personFile));
			objectOut.writeObject(personList);
			objectOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}//end writePerson()
	
	

	@SuppressWarnings("unchecked")
	public static void readPersonFile() {
		
		ObjectInputStream objectIn;
		/*try {
			objectIn = new ObjectInputStream(new FileInputStream(personFile));
			personList = (ArrayList<Person>) objectIn.readObject();
			objectIn.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		*/
		try {
			objectIn = new ObjectInputStream(new FileInputStream(personFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}//end readPerson()
	
}//end IOCollections
