package homework1;

public class TestAbstraction extends ThreeAbstractions{

//------------------------------------Method 1: Check for Uppercase-----------------------------------------
	//Checks user's input for any uppercase letters
	//Uses a for loop to check character by character and returns true if any are uppercase, 
	//Returns a boolean
	@Override
	public boolean checkUppercase(String check) {
		boolean upperChars = false;
		for(int i = 0; i < check.length(); i++) {
			if(Character.isUpperCase(check.charAt(i))) {
				upperChars = true;
			}
		}
		return upperChars;
	}//end checkUppercase()

	
//------------------------------------Method 2: Convert to Uppercase-----------------------------------------	
	//Converts all of user's input to uppercase and returns it back
	@Override
	public String convertUppercase(String check) {
		String allUppercase = check.toUpperCase();
		return allUppercase;
	}//end convertUppercase()

	
//------------------------------------Method 3: Convert to Int-----------------------------------------
	//Converts user's input to an int
	//If input can be converted, it adds 10 and returns the new int
	//If not, it returns the input and an error will be caught in the main
	@Override
	public int convertInt(String check) {
		int userNum;
		String input = check.replace(" ", ""); //<--Replaces any spaces, so numbers are concat (i.e. "7 7" turns into "77")

		 try {
			   userNum = Integer.parseInt(input) + 10;  
			 }catch(NumberFormatException e) { 
			   userNum = Integer.parseInt(input);  
			 }
		return userNum;
			
	}//end convertInt()
	
}//end TestAbstraction class
