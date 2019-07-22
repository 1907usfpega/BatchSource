package homework1;

public class Problem17 extends UserInput{
	
	static void interest() {
		
		//Prints a prompt to ask user for Principal, Rate, and Time
		System.out.println("Q17.) To calculate your interest, please input your principal: ");
		double principal = isDouble();
		
		System.out.println("Now, please input your rate: ");
		double rate = isDouble();
		
		System.out.println("Now, please input the time: ");
		double time = isDouble();
		
		//Calculates the interest and prints it for the user
		double interest = principal * rate * time;
		System.out.println("Your interest is: $" + interest);
		
	}//end interest()

}//end Problem17
