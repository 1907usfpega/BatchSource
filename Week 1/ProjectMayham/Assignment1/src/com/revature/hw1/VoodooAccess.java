package com.revature.hw1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import com.revature.anotherpackage.Floats;


public class VoodooAccess {

	public static String voodoo() {
		Floats myFloat = new Floats();
		String output = "";
		try {
			Class<?> c = Class.forName("com.revature.anotherpackage.Floats");
			Field [] f = c.getFields();
			Field field;
			output = f.length + " fields\nFloats: ";
//			System.out.println(f.length + " fields");
//			System.out.print("Floats: ");
			for(int i = 0; i < f.length; i++) {
				field = f[i];
				output = output + field.get(myFloat) + " ";
//				System.out.print(field.get(myFloat) + " ");
			}
			output = output + "exists in a different package!";
//			System.out.println("exist in a different package!");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}
	
}
