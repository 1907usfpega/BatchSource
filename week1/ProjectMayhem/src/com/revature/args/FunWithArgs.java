package com.revature.args;

public class FunWithArgs {
	/*variable length argument
	 * method will take variable number of args
	 * automates and hides the process of creating and saving the value in an
	 * array prior to invoking the method
	 * can be of any type
	 * 
	 */
	
	
	public static void main (String[] args) {
		Integer huey=12;
		vaTest(10);
		vaTest(huey);
		vaTest(12,24,36);
		vaTest(1,2,3,4,5,6,7,8,9,10);
		vaTest("HEWWO?",true,420,69);
	}
	
	static void vaTest(int a) {
		System.out.println("only one int!");
	}
	
	static void vaTest(int ... v) {
		System.out.println("num of args is "+ v.length + "\n" + "contents:");
		for (int x: v) {
			System.out.print(x+" ");
		}
		System.out.println("");
	}
	//only 1 vararg per method, must be last param
	static void vaTest(String a, boolean b, int ... v) {
		System.out.println(a);
		System.out.println(!b);
		vaTest(v);
	}

}
