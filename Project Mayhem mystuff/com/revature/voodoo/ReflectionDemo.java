package com.revature.voodoo;

public class ReflectionDemo {

	public static void main(String[] args) {
		Class<?> c;
		try {
			c= Class.forName("javax.swing.JFrame")
		}
		
		Class<?> c= Class.forName("javax.swing.Jframe");
		
			Constructor<?>[] con= c.getConstructors();
		for( int i=0; i<con.length;i++) {
			System.out.println(" " +con[i] );
		}
		Field f[]= c.getFields();
		for( int i=0; i<f.length;i++) {
			System.out.println(" " +f[i] );
		}
		System.out.println("MEthods:");
		Method m[]=c.getMethods();
		for( int i=0; i<m.length;i++) {
			System.out.println(" " +m[i] );
		}
		catch (ClassNotFoundException e) {
			
		}

		// TODO Auto-generated method stub

	}

}
