package com.revature.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorDemo {

	public static void main(String[] args) {
		// create an arrayList
		List<String> a1 = new ArrayList<String>();
		// add elements
		a1.add("a");
		a1.add("c");
		a1.add("b");
		a1.add("f");
		a1.add("d");
		a1.add("e");
		a1.add("g");
		// use iterator to display the contents of a1
		System.out.println("Original contents of a1: ");
		Iterator<String> itr = a1.iterator();

		while (itr.hasNext()) {
			String element = itr.next();
			System.out.print(element + " ");
		}
		// Modify the objects being iterated
		ListIterator<String> litr = a1.listIterator();
		while (litr.hasNext()) {
			String element = litr.next();
			litr.set(element + "+ ");
		}
		System.out.println();
		System.out.println("Modifided contents of a1: ");
		itr = a1.iterator();
		while (itr.hasNext()) {
			String element = itr.next();
			System.out.print(element + " ");
		}
		System.out.println("\n outie boi");
		System.out.println("Modify list backwards");
		while (litr.hasPrevious()) {
			String element = litr.previous();
			System.out.print(element + " ");
		}

	}

}
