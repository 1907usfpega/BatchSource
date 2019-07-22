package com.revature.hw1;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListFun {

	public static String funWithArrayList() {
		
		String output = "";
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++) {
			al.add(i);
		}
		
		
		output = output + al.toString();
//		System.out.println(al.toString());
		
		int addEmUp = 0;
		for (int i = 2; i <= 10; i+=2) {
			addEmUp += i;
		}
		
		output = output + "\nEvens added: " + addEmUp;
//		System.out.println("Evens added: " + addEmUp);
		
		addEmUp = 0;
		for (int i = 1; i < 10; i+=2) {
			addEmUp += i;
		}
		
		output = output + "\nOdds added: " + addEmUp;
//		System.out.println("Odds added: " + addEmUp);
		
		boolean isPrime = false;
		int number;
		int check;
		
		Iterator<Integer> itr = al.iterator();
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		
		
		while(itr.hasNext()) {
			number = itr.next();
			for(int i = 2; i < number; i++) {
				check = number/i;
				if (number == check * i) {
					isPrime = true;
					break;
				}
			}
			if(isPrime) {
				al2.add(number);
			}
			isPrime = false;
		}
		al = al2;
		output = output + "\n" + al.toString();
//		System.out.println(al.toString());
		
		return output;
		
	}
	
//	public static void main(String [] args) {
//		funWithArrayList();
//	}
	
}
