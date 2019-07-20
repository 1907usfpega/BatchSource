package com.revature.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {

	public IteratorDemo() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String args[]) {
		//create arraaylist
		List<String> a1 = new ArrayList<String>();

		a1.add("C");
		a1.add("A");
		a1.add("F");
		a1.add("G");
		a1.add("D");
		a1.add("E");
		a1.add("B");
		//use iterator to display contents
		System.out.println("Original Contents of a1: " + a1);
		Iterator<String> it = a1.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
	}

}
