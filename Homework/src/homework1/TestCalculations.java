package homework1;

public class TestCalculations implements CalculationInterface{
	
	//Overrides each method of the implemented Interface
	@Override
	public void addition(double num1, double num2) {
		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
	}

	@Override
	public void subtraction(double num1, double num2) {
		System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
	}

	@Override
	public void multiplication(double num1, double num2) {
		System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));	
	}

	@Override
	public void division(double num1, double num2) {
		System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
	}
	
}//end TestCalculations class
