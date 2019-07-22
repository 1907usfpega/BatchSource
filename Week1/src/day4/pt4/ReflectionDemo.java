package day4.pt4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo {

	public static void main(String[] args) {

		Class<?> c;
		try {
			c = Class.forName("javax.swing.JFrame");

			System.out.println("Constructors: ");
			Constructor<?>[] con = c.getConstructors();
			for (int i = 0; i < con.length; i++) {
				System.out.print(" " + con[i]);
			}

			Field f[] = c.getFields();
			System.out.println("Fields: ");
			for (int i = 0; i < f.length; i++) {
				System.out.print(" " + f[i]);
			}

			Method m[] = c.getMethods();
			System.out.println("Methods: ");
			for (int i = 0; i < m.length; i++) {
				System.out.print(" " + m[i]);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}//end main

}//end ReflectionDemo class
