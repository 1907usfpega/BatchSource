package homework1;

public class Problem6 extends UserInput {

	static void evenOdd() {
		
		//Asks user to input an integer for factoring
		System.out.println("Q6.) Please enter an integer to find if it's even or odd: ");
				
		//Runs method from parent class to check for valid int
		//Stores the returned int into a variable
		//Stores a copy of the input as a double for testing
		int inputNum = isInt();
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
		
	}//end evenOdd()
	
}//end Problem6 class
