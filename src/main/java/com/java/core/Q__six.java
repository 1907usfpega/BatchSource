package com.java.core;

public class Q__six {

	public static int element;
	static public int[]numbers= {2,3,4,5,6,7,8,9,10,11,12};
	int y = numbers.length;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		element = numbers.length;
		for(int x =0; x<element;x++) {
			int num;
			int quotient =(numbers[x]/2);
			num = quotient*2;
			if(numbers[x]==num)
			System.out.println("even");else
			System.out.println("odd");
		}
	}

}//

//Q6. Write a program to determine if an integer is even without using the modulus operator (%)

//for(int x=y;x>0;x--) {
	//element = numbers[x-1];
	//System.out.print(element+" is ");
	//checkEvenOrOdd( element);
	
	
//main

/*public static void checkEvenOrOdd(int number){
	int quotient = number/2; 
	if(quotient*2== number){
		System.out.println("Using division operator: " + number + " is Even number"); 
		}else{ 
			System.out.println("Using division operator: " + number + " is Odd number"); 
			} 
	} 

*/




