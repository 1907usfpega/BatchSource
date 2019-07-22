package com.revature.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorDemo {

	public static void main(String[] args) {
		//create an arrayList
		List<String> a1 = new ArrayList<String>();
		
		a1.add("L");
		a1.add("G");
		a1.add("B");
		a1.add("T");
		a1.add("Q");
		a1.add("I");
		a1.add("A");
		a1.add("F");
		a1.add("C");
		a1.add("E");
		a1.add("D");
		
		//use iterator to display contents of a1
		System.out.println("Original contents of a1: ");
		Iterator<String> itr = a1.iterator();
		while(itr.hasNext()) {
			String element = itr.next();
			System.out.print(element+" ");
		}// end while
		
		//modify objects being iterated
		ListIterator<String> litr = a1.listIterator();
		while(litr.hasNext()) {
			String element = litr.next();
			litr.set(element+"+");
		}//end while
		
		//display everything again
		System.out.println("\n\nModified contents of a1: ");
		itr = a1.iterator();
		while(itr.hasNext()) {
			String element = itr.next();
			System.out.print(element+" ");
		}// end while
		
		//display in reverse
		System.out.println("\n\nModified Contents in reverse");
		while(litr.hasPrevious()) {
			String element = litr.previous();
			System.out.print(element+" ");
		}//end while
		
	}//end main

}
