package com.revature.varargs;

public class funWithVarArgs {

	/* Variable Length Argument
	 * Method will take a variable number of arguments
	 * automates and hides the process of creating and saving the values in an array prior to invoking the method
	 * can be of any type
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer huey = 12;
		double d = 4.5;
		vaTest(10);
		vaTest(huey);
		vaTest(d);
		vaTest(1,2,3,3,4,5,5,6,7,7,8,9,0,10,34);
		vaTest("snek",false,1,2,5,6,8,2,346,6);
	}
	static void vaTest(int a){
		System.out.println("int: "+a);
	}
	static void vaTest(double a) {
		System.out.println("double: "+a);
	}
	static void vaTest(int ... v){
		System.out.println("Number of arguments is "+v.length+".\nContents: ");
		//for each loop
		for(int x:v) //for each int x in v
		{
			System.out.print(x+" ");
		}
		System.out.println();
	}
	
	//only ONE vararg per method, must be last perameter
	static void vaTest(String a, boolean b, int ... v)
	{
		System.out.println(a);
		System.out.println(!b);
		vaTest(v);
	}
	
	
	
}
