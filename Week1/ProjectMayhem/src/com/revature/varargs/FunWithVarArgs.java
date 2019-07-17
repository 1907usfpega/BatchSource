/**
 * 
 */
package com.revature.varargs;

/**
 * @author MajorKey
 *
 */
public class FunWithVarArgs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		vaTest(10);
		System.out.println();
		vaTest(6,4,2,0,1,3,5,7,9,8);

	}

	static void vaTest(int ... v) {
		System.out.println("Number of args is: " + v.length +  ". Contents: ");
		for(int x: v) {
			System.out.print(x + ", ");
		}
	}
}
