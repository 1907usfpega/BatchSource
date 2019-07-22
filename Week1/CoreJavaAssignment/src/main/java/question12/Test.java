/**
 * 
 */
package question12;


/**
 * @author Deonta Kilpatrick
 *
 */
public class Test {

	public static void main(String [] args ) {
		//setting up the array and placing values 1-100 in it
		int[] nums = new int [100];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i + 1;
		}
		
		//send array for even numbers in it to be checked/printed 
		EvenNumbers e = new EvenNumbers();
		e.printEven(nums);
	}
}
