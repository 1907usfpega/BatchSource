/**
 * print the even numbers from 1-100
 */
package question12;

/**
 * @author Deonta Kilpatrick
 *
 */
public class EvenNumbers {

	//if the current number being checked has a remainder of 0 when divided by 2 it is even
	public void printEven(int [] nums) {
		for (int i : nums) {
			if(i % 2 == 0) {
				System.out.println(i);
			}
		}
	}
}
