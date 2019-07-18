package com.revature.voodoo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo {

	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName("javax.swing.JFrame");
			Constructor<?>[] con = c.getConstructors();
			System.out.println("Constructors: ");
			for (int i = 0; i < con.length; i++) {
				System.out.println(" " + con[i]);
			}

			System.out.println("\nFields: ");
			Field f[] = c.getFields();
			for (int i = 0; i < con.length; i++) {
				System.out.println(" " + f[i]);
			}

			System.out.println("\nMethods: ");
			Method m[] = c.getMethods();

			for (int i = 0; i < con.length; i++) {
				System.out.println(" " + m[i]);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Unable to find class.");
		}
	}

}
