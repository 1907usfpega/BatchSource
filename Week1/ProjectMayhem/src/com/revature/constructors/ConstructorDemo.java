<<<<<<< HEAD
package com.revature.constructors;

public class ConstructorDemo {
	public static void main(String [] args) {
		C c= new C();
	}
}
class A{
=======
/**
 * 
 */
package com.revature.constructors;

/**
 * @author MajorKey
 *
 */
public class ConstructorDemo {
	public static void main(String[] args) {
		C c = new C();
	}
}

class A {
>>>>>>> ec17887aa226515703225d76adef61fef521f005
	A(){
		System.out.println("Inside A's constructor");
	}
}
<<<<<<< HEAD

class B extends A{
=======
class B extends A {
>>>>>>> ec17887aa226515703225d76adef61fef521f005
	B(){
		System.out.println("Inside B's constructor");
	}
}

<<<<<<< HEAD
class C extends B{
	C(){
		System.out.println("Inside C's constructor");
	}
}


=======
class C extends B {
	C(){
		System.out.println("Inside C's constructor");
	}
}
>>>>>>> ec17887aa226515703225d76adef61fef521f005
