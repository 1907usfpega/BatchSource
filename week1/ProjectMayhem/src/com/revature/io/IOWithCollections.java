package com.revature.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.revature.beans.Person;

public class IOWithCollections {
	private static final String PERSONFILE= "person.txt";
	
	public static ArrayList<Person> pList=new ArrayList<Person>();
	
	public static void writePersonFile() {
		ObjectOutputStream oOut;
		try {
			oOut = new ObjectOutputStream(new FileOutputStream(PERSONFILE));
			oOut.writeObject(pList);
			oOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void readPersonFile() {
		ObjectInputStream oIn;
		try {
			oIn = new ObjectInputStream(new FileInputStream(PERSONFILE));
			pList=(ArrayList<Person>) oIn.readObject();
			oIn.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
