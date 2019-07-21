package com.revature.questions;
/*Create an ArrayList and insert integers 1 through 10. 
 * Display the ArrayList. 
 * Add all the even numbers up and display the result. 
 * Add all the odd numbers up and display the result.
*/
import java.util.ArrayList;
import java.util.Iterator;

public class Q19 {
	
	static ArrayList<Integer> listArray =
			new ArrayList<Integer>();
	
	//Fill and show array
	public static void showArray() {
		listArray.add(1);
		listArray.add(2);
		listArray.add(3);
		listArray.add(4);
		listArray.add(5);
		listArray.add(6);
		listArray.add(7);
		listArray.add(8);
		listArray.add(9);
		listArray.add(10);
		
		System.out.println("Display the ArrayList: ");
		System.out.println(listArray);
		
	}
	
	//iterate throught the ArrayList
	public static void sumOdd() {
		int sum = 0;

		System.out.print("\nSum ODD numbers: ");
		
		Iterator<Integer> itr=listArray.iterator();
		while (itr.hasNext()) {
			Integer element=  itr.next();
			sum = sum + isOdd(element);		
		}
		
		System.out.println(sum);
	}
	
	//iterate throught the ArrayList
	public static void sumEven() {
		int sum = 0;

		System.out.print("\nSum EVEN numbers: ");
		
		Iterator<Integer> itr=listArray.iterator();
		while (itr.hasNext()) {
			Integer element=  itr.next();
			sum = sum + isEven(element);	
		}
		
		System.out.println(sum);
	}
	
	//return if it's even
	private static int isEven(int num) {
		if(num%2==0) {
			return num;
		}
		return 0;
	}
	
	//return if it's odd
	private static int isOdd(int num) {
		if(num%2 != 0) {
			return num;
		}
		return 0;
	}

}