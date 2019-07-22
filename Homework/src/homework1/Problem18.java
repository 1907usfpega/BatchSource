package homework1;

public class Problem18 extends UserInput {

	public static void main(String[] args) {
		
		//Prints prompt for user input
		System.out.println("Q18.) Please enter any input to run tests.");
		
		//Creates a new TestAbstraction object to call the methods
		TestAbstraction test = new TestAbstraction();
		
		//Prints the beginning of the output and runs each calculation with different numbers
		String input = isString();
		
//------------------------------------Test 1: Check for Uppercase-----------------------------------------
		//Runs method to check each character of the user's input for uppercase letters
		//Stores the returned boolean in charResult
		//Prints the appropriate output based on charResult
		boolean charResult = test.checkUppercase(input);
		if(charResult) {
			System.out.println("\nYour String " + input + " contains uppercase character(s).");
		}else {
			System.out.println("\nYour String " + input + " contains no uppercase character(s).");
		}
			
		
//------------------------------------Test 2: Convert to Uppercase-----------------------------------------
		//Runs method to convert user's input to all uppercase
		//Prints the altered String to the user
		String upperResult = test.convertUppercase(input);
		System.out.println("Your String " + input + " converted to all uppercase is: " + upperResult);
		
		
//------------------------------------Test 3: Convert to Int-----------------------------------------------
		//Runs method to convert the user's input to an int
		//If user's input can be converted, it will add 10 and return the int
		//If user's input cannot be converted, will print a fail message
		try {
			int convertResult = test.convertInt(input);
			System.out.println(input + " converted to an int and + 10 is: " + convertResult);
		}catch(NumberFormatException e) { 
			System.out.println(input + " cannot be converted to an int.");
		}
		
	}//end main

}//end Problem18 class
