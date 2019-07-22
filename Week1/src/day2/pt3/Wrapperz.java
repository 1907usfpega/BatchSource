package day2.pt3;

public class Wrapperz {
	
	/*
	 * Wrappers: Wrap around primitive value and allow it to be treated as an object
	 * 		good for utility methods
	 * 
	 * Character: char
	 * Boolean: boolean
	 * Byte: byte
	 * Short: short
	 * Long: long
	 * Integer: int
	 * Float: float
	 * Double: double
	 * 
	 * Autoboxing: Implicit conversion from a primitive type to a Reference type
	 * Autounboxing: Wrapper to primitive type
	 * 		These are expensive processes
	 *		Useful if objects are required & using class defined utility methods
	 */
	
	

	public static void main(String[] args) {
		
		int myInt = 3;
		Integer myInteger = 5;
		Double myDouble = 73.97;
		//Boolean myBoo = true;
		
		int a = addEmUp(myInt, myInteger);
		System.out.println(a);
		
		int b = addEmUp(myInteger, myDouble.intValue());
		System.out.println(b);

	}//end main
	
	public static int addEmUp(int a, int b) {
		return a + b;
	}

}//end Wrapperz Class
