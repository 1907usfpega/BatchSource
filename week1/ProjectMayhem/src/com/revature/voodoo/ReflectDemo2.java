package com.revature.voodoo;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectDemo2 {

	public static void main(String[] args) {
		A a= new A();
		Class<?> c = a.getClass();
		System.out.println("Private Methods");
		Method m[]=c.getDeclaredMethods();
		for (int i=0; i<m.length;i++) {
			int mod =m[i].getModifiers();
			if (Modifier.isPrivate(mod)) {
				System.out.print(" "+m[i].getName());	
			}
		}

	}

}
class A{
	public static void a1() {
			
	}
	public static void getBent() {
		
	}
	void a2() {
		
	}
	protected void a3() {
		
	}
	private void a4() {
		
	}
	private void whoCares() {
		
	}
	
}
