/**
 * 
 */
package com.revature.core;

import java.util.ArrayList;
import com.revature.core.PrimeNumbers;

/**
 * @author MajorKey
 *Question 19
 */
public class ArraylistOps {

	/**
	 * 
	 */
	public ArraylistOps() {
		// TODO Auto-generated constructor stub
	}
	
	public int addEven(ArrayList<Integer> list) {
		int added = 0;
		for (Integer i : list) {
			if(i % 2 == 0) {
				added += i;
			}
		}
		return added;
	}
	
	public int addOdd(ArrayList<Integer> list) {
		int added = 0;
		for (Integer i : list) {
			if(i % 2 == 1) {
				added += i;
			}
		}
		return added;
	}
	
	
	public static void main(String [] args) {
		ArrayList<Integer> list = new ArrayList<> ();
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
		
		list = p.primeNums(list);
		System.out.println(list);
		
	}

}
