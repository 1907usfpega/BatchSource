package homework1;

public class Problem2 {
	
	public static String fibonacci() {
	
		//Prints the beginning of the statement to the user
		System.out.println("Q2.) Here are the first 25 numbers of the Fibonacci Sequence:");
		String result = "";
		
		int num1 = -1; //<--Default value is negative so 0 prints first
		int num2 = 1; //<--Sets default value to 1 
		int num3;
		int iter = 25; //<--Sets the number of iterations to 25 
		  
		//Iterates through a loop to print out each number
		for(int i = 0; i < iter; i++) {  
			num3 = num1 + num2;  
			System.out.print(num3 + " "); 
			result +=(num3 + " ");
			num1 = num2;  
			num2 = num3;  
		}
		
		//Returns the result string without the original null value
		return result; 
		
	}//end fibonacci()
	
}//end Problem2 class
