package Homework1;

import java.util.Scanner;

public class Problem4 {

	public static void factorial() {

		//Asks user for a numerical input
		//Closes the scanner
		//Converts input to integer
		Scanner input = new Scanner(System.in);
		
		int number = input.nextInt();
		
		//String input= JOptionPane.showInputDialog("Please input a number for factorial: ");
		//int number = Integer.parseInt(input);
		
		//Creates a variable to store result
		int factorial = 1;
		
		//Cycles through user's number and multiples all of it to get the factorial
		for(int i=1; i<=number; i++) {
			factorial *= i;
		}
		
		//Prints result back to user
		System.out.println("The factorial of " + number + " is: " + factorial);
		
		
		input.close();
	}//end factorial method

}//end Problem4 class
