package com.revature.generics;

public class GenDemo {

	public static void main(String[] args) {
		// create a Gen1 reference for Integers
		Gen1<Integer> i;
		i = new Gen1<Integer>(88);
		i.showType();
		int v = i.getOb();
		System.out.println("value " + v);
		
		Gen1<String> s = new Gen1<String>("Generics Test");
		s.showType();
		String str = s.getOb();
		System.out.println("value " + str);
		
		//generics gives us flexibility, type safety, reusiblity
		
	}

}
