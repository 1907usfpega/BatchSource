package com.revature.generics;

public class Gen1<T> {
	
	// Declare an object of type T.
	T ob;
	// Pass the constructor a reference to an object of type T.
	Gen1(T o) {
		ob = o;
	}
	
	// return ob
	T getOb() {
		return ob;
	}
	
	// Show the type of T.
	void showType() {
		System.out.println("Type of T is: " + ob.getClass().getName());
	}
	
	
	
}
