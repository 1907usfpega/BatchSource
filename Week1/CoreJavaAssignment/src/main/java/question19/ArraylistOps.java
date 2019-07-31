/**
 * 
 */
package question19;

import java.util.ArrayList;

/**
 * @author Deonta Kilpatrick
 *
 */
public class ArraylistOps {
	//checks if numbers in the list are even and adds them together
	public int addEven(ArrayList<Integer> list) {
		int added = 0;
		for (Integer i : list) {
			if(i % 2 == 0) {
				added += i;
			}
		}
		return added;
	}
	
	//checks if numbers in the list are odd and adds them together
	public int addOdd(ArrayList<Integer> list) {
		int added = 0;
		for (Integer i : list) {
			if(i % 2 == 1) {
				added += i;
			}
		}
		return added;
	}
}
