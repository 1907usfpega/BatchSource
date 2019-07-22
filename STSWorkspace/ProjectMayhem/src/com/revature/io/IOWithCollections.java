package com.revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.revature.driver.beans.Person;

public class IOWithCollections 
{
	private static final String personFile = "Person.txt";
	public static ArrayList<Person> people = new ArrayList<Person>();
	
	public static void writePersonFile()
	{
		try 
		{
			ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(personFile));
			objectOut.writeObject(people);
			objectOut.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void readPersonFile()
	{
		try 
		{
			ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(personFile));
			people = (ArrayList<Person>)objectIn.readObject();
			objectIn.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
}
