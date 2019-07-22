package com.revature.generics;

public class GenDemo {

	public static void main(String[] args) 
		{
			Gen1<Integer> i;
			i=new Gen1<Integer> (88);
			i.showType();
			int v = i.getOb();
			System.out.println("Value "+ v);
			
			
			Gen1<String> s = new Gen1<String>("Generic Test");
			s.showType();
			String str= s.getOb();
			System.out.println("Value " + str);
		}

}
