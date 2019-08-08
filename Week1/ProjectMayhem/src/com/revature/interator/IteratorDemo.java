package com.revature.interator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorDemo {

	public static void main(String[] args) {
		//create an arrayList
		List<String> a1= new ArrayList<String>();
		//add elements
		a1.add("C");
		a1.add("A");
		a1.add("G");
		a1.add("E");
		a1.add("B");
		a1.add("F");
		a1.add("G");
		//use iterator to display contents of a1
		System.out.println("Original Contents of a1: ");
		Iterator<String> itr=a1.iterator();
		while (itr.hasNext()) {
			String element= itr.next();
			System.out.print(element+" ");
		}
		//Modify objects being iterated
		ListIterator<String> litr=a1.listIterator();
		while(litr.hasNext()) {
			String element=litr.next();
			litr.set(element+"+");
		}
		System.out.println("\nRoll Tide");
		System.out.println("Modified Contents of a1: ");
		itr=a1.iterator();
		while (itr.hasNext()) {
			String element= itr.next();
			System.out.print(element+" ");
		}
		System.out.println("\nShut up Jackson");
			System.out.println("Modified List Backwords: ");
			while(litr.hasPrevious()) {
				String element=litr.previous();
				System.out.print(element+" ");
			}
			
	}

}