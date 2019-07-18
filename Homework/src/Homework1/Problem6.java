package Homework1;

import java.util.Scanner;

public class Problem6 {

	public static void main (String[] args) {
		
		//Asks user for an integer input
		//Stores input into int variable
		System.out.println("Enter an integer to see if it is even or odd:");
		Scanner input = new Scanner(System.in);
		int inputNum = input.nextInt();
		
		//Duplicates input into a double for division test
		double testNum = inputNum;

	    //Divides number by 2 for even/odd testing
	    testNum /= 2;
		
	    //Compares the quotient against the int form of itself
	    //If number has a decimal, then it is not evenly divisible by 2
	    //Displays original number back to user with result
		if((int)testNum == testNum) {
			System.out.println(inputNum + " is an even number.");
		}else {
			System.out.println(inputNum + " is an odd number.");
		}
		
		//Closes the scanner
		input.close();
		
	}//end 
	
}//end Problem6
