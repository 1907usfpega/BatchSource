package com.revature.generics;

public class gen1<T> {
	T obj;

	// pass constructor a reference to an object of type T
	gen1(T o) {
		this.obj = o;
	}

	T getObj() {
		return obj;
	}

	void showType() {
		System.out.println("Type of T is: " + obj.getClass().getName());
	}
}
