/**
 * 
 */
package question6;

/**
 * @author Deonta Kilpatrick
 *
 */
public class Modulus {
	
	//divides number by two; if that answer x2 doesn't equal the original number then the number is odd
	public boolean isEven(int num) {
		int a = num / 2;
		
		if((a * 2) == num)
			return true;
		return false;
	}
}
