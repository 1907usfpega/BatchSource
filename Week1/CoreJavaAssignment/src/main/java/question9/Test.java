/**
 * 
 */
package question9;

import java.util.ArrayList;

/**
 * @author Deonta Kilpatrick
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> list= new ArrayList<Integer> ();
		PrimeNumbers p = new PrimeNumbers();
		
		//populates the list with values from 1-100
		for(int i = 1; i <= 100; i++) {
			list.add(new Integer(i));
		}
		
		System.out.println(p.primeNums(list));

	}

}
