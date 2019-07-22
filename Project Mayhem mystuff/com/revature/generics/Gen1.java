package com.revature.generics;

public class Gen1<t> {

	//declare an object of Type t
	T ob;
	//pass the constructor to areference to an object of Type T 
	Gen1(T o) {
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
