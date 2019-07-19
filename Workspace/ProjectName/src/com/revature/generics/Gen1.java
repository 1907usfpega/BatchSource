package com.revature.generics;

public class Gen1<T> {
	
	//declare an object of type T
	T ob;
	//pass the constructor a reference to an object of type T
	Gen1(T o){
		ob=o;
	}
	//return ob
	T getOb() {
		return ob;
	}
	//show type of T
	void showType() {
		System.out.println("Objecttype is " + ob.getClass().getName());
	}
}
