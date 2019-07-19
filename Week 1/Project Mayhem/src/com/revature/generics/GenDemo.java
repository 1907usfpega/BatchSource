package com.revature.generics;

public class GenDemo {

	public static void main(String[] args) {
		//create a gen1 reference ofr integers
		gen1<Integer> i;
		i = new gen1<Integer>(88);
		i.showType();
		//get the value of i
		int v = i.getObj();
		System.out.println("value " + v);
		
		gen1<String> s = new gen1<String>("Generic Test");
		s.showType();
		String str = s.getObj();
		System.out.println("value " + str);

	}
}
