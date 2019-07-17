package com.revature.constructors;

public class ConstructorDemo {
	public static void main(String [] args) {
		C  c=new C();
	}

}
class A{
	A(){
		System.out.println("Inside A's constuctor");
	}
}

class B extends A{
	B(){
		System.out.println("Iniside B's constuctor");
	}
}

class C extends B{
	C(){
		System.out.println("Inside C's constructor");
		
	}
	
}