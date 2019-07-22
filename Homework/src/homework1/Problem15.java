package homework1;

public class Problem15 {

	public static void main(String[] args) {
		
		//Creates a new TestCalculations object to call the methods
		TestCalculations test = new TestCalculations();
		
		//Prints the beginning of the output and runs each calculation with different numbers
		System.out.println("Q15.) Here are a few quick calculations: ");
		test.addition(180, 33);
		test.subtraction(71, 1.4);
		test.multiplication(2.04, 9.9);
		test.division(66, 0.6);
		
	}//end main

}//end Problem15
