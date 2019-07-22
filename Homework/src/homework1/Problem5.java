package homework1;

public class Problem5 extends UserInput{

	static void indexString() {
		
		//Asks user for a String
		//Runs method from parent class with Scanner to save the String
		//Stores the returned String into a variable
		System.out.println("Q5.) Input a word to index: ");
		String inputString = isString();
		
		
		//Asks user for an int to index to
		//Must be between the values displayed
		System.out.println("Input an int between 1-" + inputString.length() + " to index to:");
				
		//Runs method from parent class to check for valid int
		//Stores the returned int into a variable
		int inputNum = isInt();
		
		//If the user's input if out of bounds for the String, they will be asked to input a valid int
		while(inputNum> inputString.length() || inputNum < 1) {
			System.out.println("Not a valid index. Please enter a new integer to index to: ");
			inputNum = isInt();
		}
		
		//Prints a whitespace line and the beginning of the output statement to user
		System.out.println();
		System.out.print(inputString + " index to " + inputNum + " will read: ");
		
		//Once a valid int is achieved, prints the string back to the user up til the requested index
		for(int i = 0; i < inputNum; i++) {
			System.out.print(inputString.charAt(i));
		}
		
	}//end reverseString()

}//end Problem5 class
