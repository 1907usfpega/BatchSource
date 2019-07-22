package com.revature.generics;

public class GenDemo {

	public static void main(String[] args) {
		Gen1<Integer> i;
		i=new Gen1<Integer> (88);
		i.showType();
		int v= i.getOb();
		System.out.println("Value: "+v);
		
		Gen1<String> a;
		a=new Gen1<String> ("test");
		a.showType();
		String s= a.getOb();
		System.out.println("Value: "+s);
	}

}
