package com.revature.generics;

public class gen1<T> {
	T ob;
	gen1(T o){
		ob = o;
	}
	public gen1() {
		// TODO Auto-generated constructor stub
	}
	T getOb() {
		return ob;
	}
	void showType() {
		System.out.println("Type is: " + ob.getClass().getTypeName());
	}

	public static void main(String[] args) {	
		gen1<Integer> i;
		i = new gen1<Integer>(88);
		i.showType();
	}

}
