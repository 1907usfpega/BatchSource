package com.revature.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorDemo {

	public static void main(String[] args) 
		{
			//create an arraylist
			List<String> a1= new ArrayList<String>();
			a1.add("C");
			a1.add("D");
			a1.add("A");
			a1.add("G");
			a1.add("Z");
			a1.add("T");
			a1.add("F");
			a1.add("R");
			a1.add("W");
			
			//use iterator to display the contents of a1
			System.out.println("Original content of a1: ");
			
			Iterator<String> itr=a1.iterator();
			while(itr.hasNext()) 
				{
					String element =itr.next();
					System.out.print(element+ " ");
				}
			
			//modify objects being iterated
			ListIterator<String> litr= a1.listIterator();
			while(litr.hasNext()) 
				{
					String element=litr.next();
					litr.set(element + "+");
				}
			System.out.println("\nRoll Tide");
			System.out.println("modified contents of a1 :");
			itr=a1.iterator();
			while (litr.hasNext()) 
				{
					String element=itr.next();
					System.out.println(element+ " ");
				}
			System.out.println("backward");
			while(litr.hasPrevious()) 
				{
					String element=litr.previous();
					System.out.println(element+ " ");
				}
			
			
		}

}
