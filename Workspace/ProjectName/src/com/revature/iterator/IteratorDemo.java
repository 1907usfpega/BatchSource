package com.revature.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorDemo {
	
	public static void main(String[] args) {
		/*
		 * create an arrayList
		 */
		List<String> a1 = new ArrayList<String>();
		a1.add("C");
		a1.add("D");
		a1.add("A");
		a1.add("B");
		a1.add("E");
		a1.add("G");
		a1.add("F");
		//use iterator, to display contents of a1
		System.out.println("Original Contents: ");
		Iterator<String> itr = a1.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next());
		}
		ListIterator<String> litr = a1.listIterator();
		System.out.println("\n" + litr.toString());
		while(litr.hasNext()) {
			String element = litr.next();
			litr.set(element + "+");
			//System.out.println(litr.next());
		}
		itr = a1.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next());
		}
		itr = a1.iterator();
		System.out.println("\n" + "Modified List Backwards");
		while(litr.hasPrevious()) {
			System.out.print(litr.previous());
		}
	}
}
