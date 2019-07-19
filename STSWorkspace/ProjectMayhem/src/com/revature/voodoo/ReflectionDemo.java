package com.revature.voodoo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo 
{
	public static void main(String[] args) 
	{
		Class<?> c;
		try 
		{
			c = Class.forName("javax.swing.JFrame");
			
			System.out.println("Constructors: ");
			Constructor<?>[] con = c.getConstructors();
			for(int i = 0; i < con.length; i++)
			{
				System.out.println(" "+con[i]);
			}
			
			System.out.println("\nFields: ");
			Field[] fields = c.getFields();
			for(int i = 0; i < fields.length; i++)
			{
				System.out.println(" "+fields[i]);
			}
			
			System.out.println("\nMethods: ");
			Method[] meths = c.getMethods();
			for(int i = 0; i < meths.length; i++)
			{
				System.out.println(" "+meths[i]);
			}
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
}
