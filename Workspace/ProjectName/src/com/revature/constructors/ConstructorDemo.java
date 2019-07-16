package com.revature.constructors;

public class ConstructorDemo {

	public static void main(String[] ogre) {
		C c = new C();
	}
}
class A  {
	A(){
		super();
		System.out.println("Inside A's Constructor");
	}
}
class B extends A {
	B(){
		super();
		System.out.println("Inside B's Constructor");
	}
}
class C extends B {
	C(){
		
		System.out.println("Inside C's Constructor");
	}
}