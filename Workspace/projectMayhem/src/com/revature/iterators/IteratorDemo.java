package com.revature.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorDemo {

	public static void main(String[] args) {
		// create an ArrayList
		List<String> a1 = new ArrayList<String>();
		//import java.util.list
		a1.add("C");
		a1.add("D");
		a1.add("G");
		a1.add("B");
		a1.add("A");
		a1.add("F");
		a1.add("E");
		//use iterator to display contents of a1
		System.out.println("original contents of a1: ");
		Iterator<String> itr = a1.iterator();
		//import util.iterator
		
		while (itr.hasNext()) {
			String element = itr.next();
			System.out.print(element + " ");
		}
		
		//Modify the object being iterated
		ListIterator<String> litr = a1.listIterator();
		while (litr.hasNext()) {
			String element = litr.next();
					litr.set(element+ " + ");
		}
		
		System.out.println("modified contents of a1: ");
		itr = a1.iterator();
		while (itr.hasNext()) {
			String element = itr.next();
			System.out.print(element + " ");
		}
		
		//backwords use hasPrevious
		System.out.println("\nShut up Jackson");
		System.out.println("Modified List Backwards");
		while (litr.hasPrevious()) {
			String element = litr.previous();
			System.out.print(element + " ");
		}
	}

}
