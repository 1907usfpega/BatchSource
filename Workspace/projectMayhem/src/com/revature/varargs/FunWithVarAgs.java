package com.revature.varargs;

public class FunWithVarAgs {
	//variable length argument
	//method will take a variable number of arguments
	//automates and hides the process of creating and
	//saving the values into an array 
	//prior to invoking the method
	//can be of any type

	public static void main(String[] args) {
		vaTest(10);
		vaTest(1, 2, 3, 4, 5, 6, 7, 8, 9, 34);
		vaTest2("Roll Tide", false, 1,2,3,4,5,6,7,8,9,32);
		
		

	}
	//variable number of arguments
	static void vaTest(int ... v) {
		System.out.println("Number of arguments is: " +
				v.length + "Content:");
		for (int x:v) {
			System.out.println(x + ", ");
		}
				
		
	}//end
	//only 1 var arg per method, must be last parameter
	static void vaTest2(String a, boolean b, int ...v) {
		System.out.println(a);
		System.out.println(!b);
		vaTest(v);
	
	}
	
	
	

}

