package com.revature.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorDemo
{
	public static void main(String[] args) 
	{
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("E");
		list.add("G");
		list.add("C");
		list.add("B");
		list.add("D");
		list.add("F");
		System.out.println("Orginal Contents of a1: ");
		Iterator<String> itr = list.iterator();
		while(itr.hasNext())
		{
			System.out.print(itr.next()+ " ");
		}
		System.out.println("\nRoll Tide");
		ListIterator<String> litr = list.listIterator();
		while(litr.hasNext())
		{
			String element = litr.next();
			litr.set(element + " +");
		}
		
		System.out.println("Modified Contents of a1: ");
		itr = list.iterator();
		while(itr.hasNext())
		{
			System.out.print(itr.next()+ " ");
		}
		System.out.println("\nShut Up Jackson");
		System.out.println("Modified List Backwards: ");
		while(litr.hasPrevious())
		{
			String element = litr.previous();
			System.out.print(element+" ");
		}
	}
}
