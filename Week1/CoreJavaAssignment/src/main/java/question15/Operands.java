/**
 * 
 */
package question15;

/**
 * @author Deonta Kilpatrick
 *implements the abstract methods from the IOperands interface
 */
public class Operands implements IOperands {

	//returns the value of the two numbers added together
	public int addition(int a, int b) {
		return a + b;
	}

	//returns the value of the two numbers subtracted from each other
	public int subtraction(int a, int b) {
		return a - b;
	}

	//returns the value of the two numbers multiplied together
	public int multiplication(int a, int b) {
		return a * b;
	}

	//returns the value of the two numbers divided by each other
	public int division(int a, int b) {
		return a / b;
	}

}
