package day3.pt2;

public class NegativeNumberException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3034108308980519676L;

	public NegativeNumberException() {
		System.out.println("Cannot increase by a negative number.");
	}
	
}//end NegativeNumberException class
