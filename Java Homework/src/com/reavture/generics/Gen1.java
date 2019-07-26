package com.reavture.generics;

public class Gen1<T> {
	/*Generics
	 * using a type as parameter
	 * write code that can handle diff types of objects
	 * use angle brackets <> to denote that something is a generic
	 * Allows us to ensure type safety
	 * adds stability and reusability to our code
	 * Placeholder(T,E,?,etc.)- use instead of an explicit type
	 */
	//declare an object of Type T
		T ob;
		//pass the constructor a reference to an object of Type T
		Gen1(T o){
			ob=o;
		}
		//return ob
		T getOb() {
		return ob;
		}
		//Show the Type of T
		void showType() {
			System.out.println("Type of T is: "
		+ ob.getClass().getName());
		}
}
