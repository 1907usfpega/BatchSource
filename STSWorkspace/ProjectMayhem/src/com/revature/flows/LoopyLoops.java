package com.revature.flows;

import com.revature.driver.beans.Person;

public class LoopyLoops 
{
	static String color;
	
	public static void main(String[] args) 
	{
		/*
		 * If statements
		 * for decision making, provides multiple paths of execution
		 * 
		 * Switch cases
		 * provides multiple paths of execution based on some value
		 * the switch is based on an integer numeric, a string, a char, an enum, or a boolean
		 * if therre are no breaks in a switch, there can be fall through
		 */
		//whatColor("green");
		//forLoopFunness(30);
		//forEachLoopFun(myArray);
		//whatColor("s");
		//wileyWhile(-34);
		//doWileyWhile(-34);
		//checkStuff(1, 1);
		//checkStuff(1, 2);
		Person a = new Person("Matt", 33, 270);
		Person b = new Person("Jackson", 56, 199);
		Person c = new Person("Matt", 33, 270);
		checkStuff(a, a);
		checkStuff(a, b);
		checkStuff(a, c);
		
	}
	
	public static void whatColor(String color)
	{
		switch(color)
		{
			case "green":
				System.out.println("yo dawg this color's green");
				break;
			case "orangered":
				System.out.println("what even is this color");
				break;
			case "purple":
				System.out.println("purple is pretty kewl");
				break;
			case "puce":
				System.out.println("Don't take any more suggestions from Jackson");
				break;
			default:
				System.out.println("you suck!");
				break;
		}
		
	}
	/*
	 * For Loops
	 * for(a;b;c)
	 * a is variable declaration (counter)
	 * b is the ending condition
	 * c is the incrementor/decrementor
	 */
	
	public static void forLoopFunness(int p)
	{
		for(int i = p; i > 0; i--)
		{
			if(i == 10)
			{
				//break;
				//exits the loop
				//continue;
				//skips to the next iteration of the loop
			}
			System.out.println(i);
		}
	}
	
	/*
	 * Enhanced for loop, or for each loop
	 * for (x: Array or Collection)
	 * good for moving through collections, arrays and other iterables
	 * more cpu efficient
	 * no issues w/index out of bounds
	 * good for accessing elements, bad for removing/adding
	 */
	
	static int[] myArray = {12, 34, 56, 78, 90};
	public static void forEachLoopFun(int[] a)
	{
		for(int i : a)
		{
			System.out.println(i);
		}
	}
	
	/*
	 * While loops
	 * while(condition){do something}
	 * 
	 * do {do something} while(condition)
	 */
	
	public static void wileyWhile(int i)
	{
		while(i++ < 10)
		{
			System.out.println("This is so exciting...not! " + i);
			//i++;
		}
	}
	
	public static void doWileyWhile(int i)
	{
		do
		{
			System.out.println("still boring " + i);
			i++;
		}while(i < 10);
	}
	
	/*
	 * Operators
	 * < > <= => != ==
	 * ORs:
	 * a|b bitwise
	 * a||b short circut. If a is tru, return true w/o b
	 * ANDs
	 * a&b bitwise
	 * a&&b checks both and evaluates true iff both are true
	 * EQUALS ==
	 * compare values of primitives
	 * compare the reference for the objects, not the contents
	 * != is good for checking nulls
	 * .equals()
	 * method inherited from Object()
	 * All reference types have it
	 * looks at content
	 */
	
	public static void checkStuff(int a, int b)
	{
		if(a==b)
		{
			System.out.println("these values are the same");
		}
		else
		{
			System.out.println("these values are not the same");
		}
	}
	
	public static void checkStuff(Person s, Person t)
	{
		if(s.equals(t))
		{
			System.out.println("these persons are the same");
		}
		else
		{
			System.out.println("these persons are not the same");
		}
	}
}
