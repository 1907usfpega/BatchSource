package com.revature.hw1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
 * Accesses two floats from separate packages. Wonder if this is that magic stuff Matt was talking about. XD
 * TODO: Look into Reflections. How to implement it beyond training example.
 * 
 * Creating two different packages to test this: com.foo & com.bar. :D
 */

public class Q11 {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Class<?> c;
		try {
			c = Class.forName("com.revature.foo.Foo");
			
			
			//Gets declared field(Think this is necessary for private values?
			//Field[] privates = c.getDeclaredFields(); 

			System.out.println("");
			System.out.println(c.getCanonicalName() + " Fields: ");
			Field[] f = c.getDeclaredFields();
			for (int i = 0; i < f.length; i++)
			{
				System.out.print(" " + f[i]);
			}
			
			c = Class.forName("com.revature.bar.Bar");
			System.out.println("");
			System.out.println(c.getCanonicalName() + " Fields: ");
			Field[] g = c.getDeclaredFields();
			for (int i = 0; i < g.length; i++)
			{
				System.out.print(" " + g[i]);
			}
	

		}
		catch (ClassNotFoundException e) {
			System.out.println("You done messed up.");
			e.printStackTrace();
		}

	}

}
