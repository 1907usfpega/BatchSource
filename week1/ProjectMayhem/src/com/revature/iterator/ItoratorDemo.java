package com.revature.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ItoratorDemo {

	public static void main(String[] args) {
		List<String> a1=new ArrayList<String>();
		a1.add("C");
		a1.add("A");
		a1.add("G");
		a1.add("D");
		a1.add("F");
		a1.add("E");
		a1.add("B");
		
		System.out.println("original contents: ");
		Iterator<String> itr=a1.iterator();
		while(itr.hasNext()) {
			String element=itr.next();
			System.out.print(element+" ");
		}
		
		ListIterator<String> litr=a1.listIterator();
		
		while(litr.hasNext()) {
			String element=litr.next();
			litr.set(element+"+");
		}
		
		System.out.println("\nModified contents: ");
		itr=a1.iterator();
		while(itr.hasNext()) {
			String element=itr.next();
			System.out.print(element+" ");
		}
		
		System.out.println("\nBackwards contents: ");
		while(litr.hasPrevious()) {
			String element=litr.previous();
			System.out.print(element+" ");
		}
		
		
	}

}
