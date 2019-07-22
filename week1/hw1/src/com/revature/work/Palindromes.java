package com.revature.work;

import java.util.ArrayList;
import java.util.Iterator;

public class Palindromes {

	public static ArrayList<String> makePals() {
		//makes the array list bc it was ugly in the driver
		ArrayList<String> a = new ArrayList<String>();
		a.add("karan");
		a.add("madam");
		a.add("tom");
		a.add("civic");
		a.add("radar");
		a.add("jimmy");
		a.add("kayak");
		a.add("john");
		a.add("refer");
		a.add("billy");
		a.add("did");
		return pals(a);
	}

	public static ArrayList<String> pals(ArrayList<String> al) {
		boolean pal;
		ArrayList<String> b=new ArrayList<String>();
		Iterator<String> it= al.iterator();
		//checks if any element of al is a palindrome
		//and if it is, saves it in b
		while(it.hasNext()) {
			String a=it.next();
			int i=0; int j=a.length()-1;
			while(i<j) {
				pal=true;
				if(a.charAt(i)!=a.charAt(j)) {
					pal=false;
					break;
				}
				if(pal) {
					b.add(a);
					break;
				}
				i++;
				j--;
			}
		}
		//prints original list
		System.out.println("Original List: ");
		it=al.iterator();
		while(it.hasNext()) {
			String element=it.next();
			System.out.print(element+" ");
		}
		//removes palindromes
		al.removeAll(b);
		
		System.out.println("\nNonPalindromes:");
		it=al.iterator();
		while(it.hasNext()) {
			String element=it.next();
			System.out.print(element+" ");
		}
		//prints palindromes
		System.out.println("\nPalendromes:");
		it=b.iterator();
		while(it.hasNext()) {
			String element=it.next();
			System.out.print(element+" ");
		}
		return b;
	}
}
