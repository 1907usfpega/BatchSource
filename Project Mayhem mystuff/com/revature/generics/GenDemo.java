package com.revature.generics;

public class GenDemo {

	public static void main(String[] args) {
		// Create a Gen1 Refernce for Integers
		Gen1<Integer> i;
		i= new Gen1<Integer>(88);
		i.showType();
		//get value of i
		int v- i.getOb();
		System.out.println("valuoe: "+ v);
		
		Gen1<string> s = new Gen1<String>("Generics Test");
		s.showType();
		String str = s.getOb();

	}

}
