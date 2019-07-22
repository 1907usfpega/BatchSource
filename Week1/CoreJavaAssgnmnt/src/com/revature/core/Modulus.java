/**
 * 
 */
package com.revature.core;

/**
 * @author MajorKey
 *Question 6
 */
public class Modulus {

	public boolean isEven(int num) {
		int a = num / 2;
		
		if((a * 2) == num)
			return true;
		return false;
	}
}
