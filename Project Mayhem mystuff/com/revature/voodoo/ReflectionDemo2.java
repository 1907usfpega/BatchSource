package com.revature.voodoo;

public class ReflectionDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a= new A();
		Class<?> c=a.getClass();
		System.out.println("Public Methods");
		Method m []=c.getDeclaredMethods();
		//there was a shortcut that the whole classed used 
	
	
		for( int i=0; i<m.length;i++) {
			int modifiers = m[i].getModifiers();
			if(modifier.isPrivate(modifiers)) {
				System.out.print( " "+ m[i].getName());
			}
				

	}

}
 class A{
	 public static void a1() {
		 
		 
	 }
	 void a2() {
		 
	 }
	 protected void a3() {
		 
	 }
	 private void a4() {
		 
	 }
	 void
 }