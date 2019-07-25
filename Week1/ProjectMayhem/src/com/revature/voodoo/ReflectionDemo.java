package com.revature.voodoo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo {
	/*
	 * Reflection a way for Java to inspect itself at runtime breaks encapsulation!
	 * Contains methods for runtime inspection of objects -Class of objext -Feilds
	 * -methods -constructors - this include private members can modifty or
	 * instantiate things, invoke, etc. java.lang.reflect
	 * 
	 */
	public static void main(String[] args) {

		Class<?> c;
		try {
			c = Class.forName("javax.swing.JFrame");

			System.out.println("Constructors:");
			Constructor<?>[] con = c.getConstructors();
			for (int i = 0; i < con.length; i++) {
				System.out.print(" " + con[i]);
			}
			System.out.println("\nFields:");
			Field f[] = c.getFields();
			for (int i = 0; i < f.length; i++) {
				System.out.print(" " + f[i]);
			}
			System.out.println("\nMethods:");
			Method m[] = c.getMethods();
			for (int i = 0; i < m.length; i++) {
				System.out.print(" " + m[i]);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
