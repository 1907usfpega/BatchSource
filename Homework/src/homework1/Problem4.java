package homework1;

public class Problem4 extends UserInput{
	
	static void factorial() {

		//Asks user to input an integer for factoring
		System.out.println("Q4.) Please enter an integer to find its factorial: ");
		
		//Runs method from parent class to check for valid int
		//Stores the returned int into a variable
		int factorial = isInt();
		
		//Creates a variable to store the result
		double result = 1;
		
		//If user's number is not negative, it cycles through user's number and multiples all of it to get the factorial
		//If user's number is negative, it prints a message to the user
		if(factorial >= 0) {
			for(int i=1; i<=factorial; i++) {
				result *= i;
			}
			//Prints a successful result back to the user
			System.out.println("The factorial of " + factorial + " is: " + result);
			
		}else {
			System.out.println("Cannot get the factorial of " + factorial + " because it is negative.");
		}
		
	}//end factorial()

}//end Problem4 class
