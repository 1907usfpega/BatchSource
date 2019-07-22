package com.revature.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionDemo2 {
	public static void main(String[] args) {
		A a = new A();
		
		Class<?> c = a.getClass();
		System.out.println("Public Methods: ");
		Method [] m = c.getDeclaredMethods();
		for (int i = 0; i < m.length; i++) {
			int modifiers = m[i].getModifiers();
			if(Modifier.isPublic(modifiers)) {
				System.out.print(" " + m[i].getName());
			}
		} // end for
		System.out.println("\nPrivate Methods: ");
		for (int i = 0; i < m.length; i++) {
			int modifiers = m[i].getModifiers();
			if(Modifier.isPrivate(modifiers)) {
				System.out.print(" " + m[i].getName());
			}
		} // end for
		
	}//end main
}//end ReflectionDemo2
class A{
		public static void a1() {
			
		}
		void a2() {
			
		}
		protected void a3() {
			
		}
		private void a4() {
			
		}
	}