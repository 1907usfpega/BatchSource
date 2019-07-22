package questions;

public class Q4 {

	//recursive function to compute factorial
	public static int factorial(int i) {
		if(i<0) {
			System.out.println("factorial not defined for negative numbers");
			return 0;
		}
		else if(i < 2) {
			return 1;
		}
		else {
			return factorial(i-1)*i;
		}
	}
}
