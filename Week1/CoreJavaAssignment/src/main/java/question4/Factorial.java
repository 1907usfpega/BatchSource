/**
 * 
 */
package question4;

/**
 * @author Deonta Kilpatrick
 *
 */
public class Factorial {

	//recursive solution with 2 base cases with the same return value
	//will keep multiplying the current value by the next lower number till 0
	public int factorial(int n) {
		if(n == 1 || n == 0)
			return 1;
		else 
			return(n * factorial(n - 1));
	}
}
