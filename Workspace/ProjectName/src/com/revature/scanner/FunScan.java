package com.revature.scanner;

import java.util.Scanner;

public class FunScan {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		String contents;
		System.out.println("what would you like to print?");
		contents = sc.next();
		System.out.println(contents);
		String s2 = "12";
		//contents = sc.nextLine();
		s2 = sc.nextLine();
		int intc2 = Integer.parseInt(s2);
		System.out.println(intc2 + 1);
		
		
		
		
		while(!contents.contentEquals("stop")) {
			System.out.println(contents);
			contents = sc.next();	
		}
		System.out.println("stopped");
		
	}
}
