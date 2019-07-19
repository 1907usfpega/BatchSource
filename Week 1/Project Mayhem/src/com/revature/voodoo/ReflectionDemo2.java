package com.revature.voodoo;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionDemo2 {

	public static void main(String[] args) {
		A a = new A();
		Class<?> c = a.getClass();
		System.out.println("Public Methods");
		Method m[] = c.getDeclaredMethods();
		for (int i = 0; i < m.length; i++) {
			int modifiers = m[i].getModifiers();
			if(Modifier.isPublic(modifiers)) {
				System.out.println(" " + m[i].getName());
			}
		}
	}
}

class A {
	public static void a1() {

	}

	void a2() {

	}

	protected void a3() {

	}

	private void a4() {

	}
}
