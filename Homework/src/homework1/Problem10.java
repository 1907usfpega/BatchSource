//Code Resource: https://www.geeksforgeeks.org/program-to-find-the-largest-number-using-ternary-operator/

package homework1;

public class Problem10 extends UserInput{
	
	static void minimum() {
		
		//Asks for the user's input to find the smallest number
		//Runs method from parent class with Scanner to save the doubles
		//Stores the returned doubles into variables
		System.out.println("Q10.) This will find the smallest of two numbers. Input the first number: ");
		double num1 = isDouble();
		
		System.out.println("Now input the second number for comparison: ");
		double num2 = isDouble();
		
		//Uses a ternary operation to find smallest value and store it
		double min = (num1 < num2) ? num1 : num2;
		
		//Prints out the original value and result to the user
		System.out.println("The smallest number between " + num1 +  
                " and " + num2 + " is: " + min + ". " );
		
	}//end minimum()

}//end Problem10 class
