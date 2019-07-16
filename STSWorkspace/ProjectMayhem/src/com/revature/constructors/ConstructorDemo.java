package com.revature.constructors;

public class ConstructorDemo 
{

	public static void main(String[] args) 
	{
		C c = new C(); //prints out A then B then C
	}

}

class A
{
	A()
	{
		System.out.println("Inside A's constructor");
		//A is an A
	}
}

class B extends A
{
	B()
	{
		System.out.println("Inside B's constructor");
		//B is a B and an A
	}
}

class C extends B
{
	C()
	{
		System.out.println("Inside C's constructor");
		//C is a C and a B and an A
	}
}
