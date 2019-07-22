package day4.pt4;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Demo2 {

	public static void main(String[] args) {
		
		A a = new A();
		Class<?> c = a.getClass();
		System.out.print("Public Methods:");
		Method m[] = c.getDeclaredMethods();
		
		for(int i = 0; i < m.length; i++) {
			int modifiers = m[i].getModifiers();
			if(Modifier.isPublic(modifiers)) {
				System.out.println(" " + m[i].getName());
			}
		}
		
		System.out.print("Private Methods:");
		for(int i = 0; i < m.length; i++) {
			int modifiers = m[i].getModifiers();
			if(Modifier.isPrivate(modifiers)) {
				System.out.println(" " + m[i].getName());
			}
		}
		
	}//end main
}//end Demo class

class A{
	public static void a1() {
		
	}
	
	void a2() {
		
	}
	protected void a3() {
		
	}
	private void a4() {
		
	}
}