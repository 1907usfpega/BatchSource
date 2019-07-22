package homework1;

import java.util.Calendar;

public class Problem14 extends UserInput{
	
	static void switchCase() {
		
		//Prints instructions to user and asks for input
		//Runs method from parent class with Scanner to save the int
		//Stores the returned int into a variable
		System.out.println("Q14.) Please type either 1, 2, or 3 to active the following: ");
		System.out.println("(1)Calculate the square root  (2)Display today's date  (3)Split a String ");
		int selection = isInt();
		
		//Tests if user's input is within the scope of the switch case
		//If it is not, it will ask the user to please input a a new int within the testing parameters
		while(selection != 1 && selection!= 2 && selection != 3) {
			System.out.println("Invalid input. Please type either 1, 2, or 3 to active the following: ");
			System.out.println("(1)Calculate the square root  (2)Display today's date  (3)Split a String ");
			selection = isInt();
		}
		
		
		//Runs the following cases based on the user's input
		//Case 1 will find the square root of a number chosen by the user
		//Case 2 will print out today's date
		//Case 3 will split a string and return it back to the user
		switch(selection) {
		case 1:;
			System.out.println("\nEnter any number to see its square root: ");
			double squareRoot = isDouble();
			System.out.println("The square root of " + squareRoot + " is: " + Math.sqrt(squareRoot));
			break;
		case 2:
			System.out.print("\nToday's date is: " + Calendar.getInstance().getTime());
			break;
		case 3:
			String splitThis = "I am learning Core Java";
			String[] splitArray = splitThis.split(" ");  //<--Splits the string on each space and stores it in a String Array
			
			//Prints Array to the user
			System.out.println("\nThe split string is: ");
			for (int i = 0; i < splitArray.length; i++) {
	            System.out.println(splitArray[i]);
			}
			break;
		}
		
	}//end switchCase()

}//end Problem14 class
