package com.revature.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo {
	public static void main(String[] args) {

		Class<?> c;
		try {
			c = Class.forName("javax.swing.JFrame");

			System.out.println("Constructors:");
			Constructor<?>[] con = c.getConstructors();
			for (int i = 0; i < con.length; i++) {
				System.out.print(" " + con[i]);
			} // end for
			System.out.println("\nFields:");
			Field f[] = c.getFields();
			for (int i = 0; i < f.length; i++) {
				System.out.print(" " + f[i]);
			} // end for
			System.out.println("\nMethods:");
			Method m[] = c.getMethods();
			for (int i = 0; i < m.length; i++) {
				System.out.print(" " + m[i]);
			} // end for

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // end catch
	}

}
