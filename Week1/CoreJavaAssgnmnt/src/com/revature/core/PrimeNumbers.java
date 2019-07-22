/**
 * 
 */
package com.revature.core;

import java.util.ArrayList;

/**
 * @author MajorKey
 *Question 9
 */
public class PrimeNumbers {

	// tasks from 2 - 11: remove all multiples till hundred 
	//overall index starting at 1; take number at index and
	//create multiples of the current indexed number up to 100 
	//doing list.remove(new Integer(multiple))
	//increment overall index repeat
	public ArrayList<Integer> primeNums(ArrayList<Integer> list) {
		final int BEGIN_LEN =list.size();
		int index = 1;
		boolean stillChecking = true;
		while((index < list.size()) && stillChecking) {
			int currNum = list.get(index);
			int multiple = 0;
			int multiply = 2;
			while(multiple <= BEGIN_LEN) {
				//create multiples till 100
				//remove multiple
				multiple = currNum * multiply;
				list.remove(new Integer(multiple));
				multiply++;
			}
			if(currNum * currNum > BEGIN_LEN) 
				//can make an original size variable for reusability of longer than 100 numbers
				stillChecking = false;
			index++;
		}
		list.remove(new Integer(1));
		return list;
	}
	
	public static void main(String []args) {
		ArrayList<Integer> list= new ArrayList<> ();
		PrimeNumbers p = new PrimeNumbers();
		
		for(int i = 1; i <= 100; i++) {
			list.add(new Integer(i));
		}
		
		System.out.println(p.primeNums(list));
	}
}