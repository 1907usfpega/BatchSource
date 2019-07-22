package homework1;

public class Problem3 {

	static void reverseString() {
		
		//Creates a string to be reversed
		String reverseThis = "Chocolate Chip Cookies";
		
		//Prints the original phrase to the user followed by part of the remaining print statement
		System.out.print("Q3.) \"Chocolate Chip Cookies\" spelled backwards is: ");
		
		//Uses a for loop to print each character of the String from last to first
		for(int i = reverseThis.length()-1; i >= 0; i--) {
			System.out.print(reverseThis.charAt(i));
		}
		
	}//end reverseString()
	
}//end Problem3 class
