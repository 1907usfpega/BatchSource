/**
 * 
 */
package com.revature.core;

/**
 * @author MajorKey
 *Question 4
 */
public class Factorial {

	int factorial(int n) {
		if(n == 1 || n == 0)
			return 1;
		else 
			return(n * factorial(n - 1));
	}
}
