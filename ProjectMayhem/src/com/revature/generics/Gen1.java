package com.revature.generics;
//added <T> to allow us to handle generic T
public class Gen1<T> {

	//declare an object of Type T
	T ob;
	
	//constructor that takes a reference to an object of type T
	Gen1(T o){
		ob = o;
	}
	//return ob
	T getOb() {
		return ob;
	}
	//show the Type of T
	void showType() {
		System.out.println("Type of T is: "+ob.getClass().getName());
	}
	

}
