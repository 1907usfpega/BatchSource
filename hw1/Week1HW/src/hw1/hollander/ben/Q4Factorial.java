package hw1.hollander.ben;

public class Q4Factorial {
	//Did not use recursion because it gave me stack overflow errors
	public static int q4(int n) {
		int factorial = 1; //Initialize to 1 (0 would cause everything to be 0)
		while (n > 1) {
			factorial *= (n);
			n -= 1; 
		}
		System.out.println(factorial);
		return factorial;
	}

}
//COMPLETED