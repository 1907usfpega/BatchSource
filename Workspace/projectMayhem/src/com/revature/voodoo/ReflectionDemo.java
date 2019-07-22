package com.revature.voodoo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo {
	//see notes
	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName("javax.swing.JFrame");
			//gave us error until try catch block
			System.out.print("Constructors: ");
			Constructor<?>[] con = c.getConstructors();
			for (int i = 0; i < con.length; i++) {
				System.out.println(" " + con[i]);
			}
			
			System.out.print("\nFields: ");
			Field f[]= c.getFields();
			for (int i = 0; i < f.length; i++) {
				System.out.println(" " + f[i]);
			}
			
			System.out.print("\nMethods: ");
			Method m[] = c.getMethods();
			for (int i = 0; i < m.length; i++) {
				System.out.println(" " + m[i]);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//highlight all inside main method
		//right click > Surround with
		//try catch block
		
		
		
		
	}

}
