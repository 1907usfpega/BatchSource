package day4.pt5;

import java.util.*;

public class Iterations {

	public static void main(String[] args) {
		//Create ArrayList

		List<String> a1 = new ArrayList<String>();
		
		//Add elements
		a1.add("C");
		a1.add("D");
		a1.add("R");
		a1.add("P");
		a1.add("A");
		a1.add("E");
		
		//Use iterator to display contents of a1
		System.out.print("Original Contents of a1: ");
		Iterator<String> itr = a1.iterator();
		
		//Print out ArrayList
		while (itr.hasNext()) {
			String element = itr.next();
			System.out.print(element + " ");
		}
		
		System.out.println(); //<--Whitespace
		
		
//------------------------------------Modify List-----------------------------------------
		//Modify objects of the ArrayList
		ListIterator<String> lit = a1.listIterator();
		while (lit.hasNext()) {
			String element = lit.next();
			lit.set(element + "+");
		}
		
		System.out.print("Modified Contents of a1: ");
		itr = a1.iterator();
		while (itr.hasNext()) {
			String element = itr.next();
			System.out.print(element + " ");
		}
		
		System.out.println(); //<--Whitespace
		
		
//------------------------------------Modify Backwards-----------------------------------------
		//Prints out list backwards
		System.out.print("Backwards Contents of a1: ");
		while(lit.hasPrevious()) {
			String element = lit.previous();
			System.out.print(element + " ");
		}
		
		
	}//end main

}//end Iterations class
