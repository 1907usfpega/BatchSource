package com.revature.overloadingexample;

public class OverLoadingExample {

	public OverLoadingExample() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String []args) {
		int num = 13;
		char let = 'j';
		double dec = 3.14;
		int arr[] = {1,1,2,3,5,8};
		Integer Num = 3;
		
		//Exact Variables
		System.out.println("This uses exact variables.");
		someMethod(num, let, dec, arr);
		System.out.println();
		
		//Conversion
		System.out.println("This converts.");
		someMethod(Num.intValue(), let, dec, arr);
		System.out.println();
		
		//Unboxing
		System.out.println("This unboxes an integer.");
		someMethod(Num, let, dec, arr);
		System.out.println();
		
		//Varargs
		System.out.println("This uses Varargs.");
		someMethod(num, let, dec, let);
		
		
		
		
		
	}
	
	public static void someMethod(int number, char letter, double decimal, int ... array) {
		System.out.println("My int is " + number);
		System.out.println("My letter is " + letter);
		System.out.println("My decimal is " + decimal);
		System.out.println("My array is: ");
		
		for(int x = 0; x < array.length; x+=1) {
			System.out.print(array[x] + ", ");
		}
		System.out.println();
	}
}
