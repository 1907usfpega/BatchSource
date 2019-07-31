/**
 * 
 */
package question2;

/**
 * @author Deonta Kilpatrick
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FibonacciNumbers fib = new FibonacciNumbers();
		int [] arr = fib.getFibSeq();
		fib.printFib(arr);
	}

}
