package com.revature.generics;

public class GenDemo {

	public static void main(String[] args) 
	{
		Gen1<Integer> i = new Gen1<Integer>(88);
		i.showType();
		//get value of i
		int v = i.getObj();
		System.out.println("value: "+v);
		
		Gen1<String> s = new Gen1<String>("Generic Test");
		s.showType();
		//get value of s
		String str = s.getObj();
		System.out.println("value: "+str);
	}

}
