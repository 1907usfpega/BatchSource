package com.revature.constructors;

public class ConstructorDemo {
	public static void main(String[] args) {
		C c = new C();
		System.out.println();
		C lilC = new C("hi");
	}
}
class A{
	A(){
		System.out.println("Inside A's default constructor");
	}
	A(String a){
		System.out.println("Inside A's paramatized constructor.");
	}
}

class B extends A{
	B(){
		System.out.println("Inside B's default constructor");
	}
	B(String b){
		System.out.println("Inside B's paramatized constructor.");
	}
}

class C extends B{
	C(){
		System.out.println("Inside C's default constructor");
	}
	C(String c){
		System.out.println("Inside C's paramatized constructor.");
	}
}