package com.revature.scanner;

public class FunScan {
	public static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) {
		String contents;
		System.out.println("What would you like to print?");
		contents=sc.next();
		System.out.println(contents);
		System.out.println(" and then?");
		String s1= sc.nextline(); //if we have a space we need to have .nextline to print the whole sentence 
		System.out.println(s1);
		System.out.println("Wat whole number");
		String s2= sc.nextLine();
		
		int c2= Integer.pareseInt(s2);
		System.out.println(c2);
	}


	}

}
