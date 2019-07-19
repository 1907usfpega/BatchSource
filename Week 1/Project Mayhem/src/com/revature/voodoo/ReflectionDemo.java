package com.revature.voodoo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo {

	//A way to get all this class information 
	//WITHOUT IMPORTING IT!
	public static void main(String[] args) {
		Class<?> c;
		try {
			c = Class.forName("javax.swing.JFrame");
			System.out.println("Constructors:");
			Constructor<?>[] con = c.getConstructors();
			for (int i = 0; i < con.length; i++) {
				System.out.println(" " + con[i]);
			}
			System.out.println("Fields:");
			Field f[] = c.getFields();
			for (int i = 0; i < f.length; i++) {
				System.out.println(" " + f[i]);
			}
			System.out.println("Methods:");
			Method m[] = c.getMethods();
			for (int i = 0; i < m.length; i++) {
				System.out.println(" " + m[i]);
			}
		} catch (ClassNotFoundException e) {

		}

	}

}
