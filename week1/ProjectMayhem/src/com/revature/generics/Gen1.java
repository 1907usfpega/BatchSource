package com.revature.generics;

public class Gen1<T> {
	
	//Declare object of type T
	T ob;
	//pass constructor a ref to obj of type T
	Gen1(T o){
		ob=o;
	}
	//getter
	T getOb() {
		return ob;
	}
	//show type
	void showType() {
		System.out.println("Type of T is: " + ob.getClass().getName());
	}

}
