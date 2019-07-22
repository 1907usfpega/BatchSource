package com.revature.voodoo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ReflectionDemo 
	{

		public static void main(String[] args) 
			{
				Class<?> c = Class.forName("javax.swing.Jframe");
				Constructor<?> [] con = c.getConstructors();
				for (int i = 0; i < con.length; i++) 
					{
						System.out.println(" "+con[i]);
					}
				Field f[] =c.getFields();
				
				for (int i = 0; i < f.length; i++) 
					{
						System.out.println(" "+f[i]);
					}
				System.out.println(" " + f[i]);
				
			}
		


	}
