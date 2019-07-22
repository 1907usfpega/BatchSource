package com.revature.iterator;

public class IteratorDemo {
	// copy and pasted notes
	
	public static void main(String[] args) {
		//create an arrayList
		List<String> a1= new ArrayList<String>();
		//add elements 
		a1.add("C");
		a1.add("D");
		a1.add("E");
		a1.add("G");
		a1.add("F");
		a1.add("A");
		a1.add("B");
		//use iterator to display contents of a1
		System.out.println("Original contents of a1:");
		Iterator<String> itr=a1.iterator();
		while (itr.hasNext()) {
			String element= itr.next();
			System.out.println(element+ " ");
		}
		//Modify objects being iterated
		ListIterator<String> litr= a1.listIterator();
		while(litr.hasNext()) {
			String element= litr.next();
			litr.set(element+ "+");
		}
		System.out.println("Roll Tide");
		System.out.println("Modified Contents of a1: ");
		itr=a1.iterator();
		while(litr.hasNext()) {
			String element= litr.next();
			litr.set(element+ "+");
		}
		System.out.println("\nShut up Jackson");
		System.out.println("Modified List Backwards: ");
		while(litr.hasPrevious()) {
			String element= litr.previous();
			System.out.println(element+ " ");
		}
			//didnt finish copying notes from board 
 	}

}
