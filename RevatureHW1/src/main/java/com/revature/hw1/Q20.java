package com.revature.hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 *  Create a notepad file called Data.txt and enter the following:
 *  Mickey:Mouse:35:Arizona
 *  Hulk:Hogan:50:Virginia
 *  Roger:Rabbit:22:California
 *  Wonder:Woman:18:Montana
 *  Write a program that would read from the file and print it out 
 *  to the screen in the following format:
 *  Name: Mickey Mouse
 *  Age: 35 years
 *  State: Arizona State
 */

public class Q20 {
	
	private static final String dataFile = "Data.txt";
	public static ArrayList<Toon> toonList = new ArrayList<Toon>();
	
	@SuppressWarnings("unchecked")
	public void readData()
	{
		try {
			Scanner read = new Scanner(new File(dataFile));
			read.useDelimiter(":");
			while(read.hasNext())
			{
			Toon toon = new Toon();
			toon.setFirst(read.next());
			//System.out.println(toon.getFirst());
			toon.setLast(read.next());
			//System.out.println(toon.getLast());
			toon.setAge(read.next());
			toon.setState(read.nextLine());
			toonList.add(toon);
	
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		printData(toonList);
		
	}
	
	public void printData(ArrayList<Toon> a)
	{
		for (int i = 0; i < a.size(); i++)
		{
			System.out.println("Name: " + a.get(i).getFirst() +
					" " + a.get(i).getLast());
			System.out.println("Age: " + a.get(i).getAge() + " years");
			System.out.println("State: " + a.get(i).getState());
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Toon
{
	private String first;
	private String last;
	private String age;
	private String state;
	
	public Toon()
	{
		
	}
	
	public Toon(String f, String l, String a, String s)
	{
		first = f;
		last = l;
		age = a;
		state = s;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Toon [first=" + first + ", last=" + last + ", age=" + age + ", state=" + state + "]";
	}
	
	
	
}
