/**
 * 
 */
package com.revature.varargs;

/**
 * @author MajorKey
 * Order of Operations:
 * Exact MAtch 
 * Conversion ref to ref prim to prim
 * boxing
 * varargs
 */
public class Overloading {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 6;
		Integer b = 5;
		double c = 5.6;
		test(a);
		test(b);
		test(c);
		test(5, 6, 9, 2, 1);
	}	
	
	static void test(double a) {
		System.out.println(a);
	}
	/*static void test(int a) {
		System.out.println(a);
	}
	static void test(Integer a) {
		System.out.println(a);
	}*/
	static void test(int ... a) {
		System.out.println(a);
	}
}
