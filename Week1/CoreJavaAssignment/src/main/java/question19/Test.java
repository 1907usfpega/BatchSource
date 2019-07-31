/**
 * 
 */
package question19;

import java.util.ArrayList;

import question9.PrimeNumbers;

/**
 * @author Deonta Kilpatrick
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer> ();
		ArraylistOps op = new ArraylistOps();
		PrimeNumbers p = new PrimeNumbers();
		
		for (int i = 0; i < 10; i++) {
			list.add(new Integer(i+1));
		}
		System.out.println(list);
		
		System.out.println("This is all the even numbers added up: " + 
		op.addEven(list));
		
		System.out.println("This is all the odd numbers added up: " + 
				op.addOdd(list));
		
		//a list of the prime numbers in the original list of numbers
		list = p.primeNums(list);
		System.out.println(list);

	}

}
