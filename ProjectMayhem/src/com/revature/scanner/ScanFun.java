package com.revature.scanner;

import java.util.Scanner;

public class ScanFun {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String contents;
		System.out.println("What would you like to print?");
		contents = sc.nextLine();
		System.out.println(contents);
		System.out.println("And then?");
		String s1 = sc.nextLine();
		System.out.println(s1);
		System.out.println("What whole number?");
		String s2 = sc.nextLine();
		int c2 = Integer.parseInt(s2);
		System.out.println(c2);
		
		
	}// end main

}// end ScanFun
