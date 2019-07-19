package com.revature.scanner;

import java.util.Scanner;

public class FunScan {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String contents; 
		System.out.println("what would you like to print my boi?");
		contents = sc.nextLine();
		System.out.println(contents);
		System.out.println("and then");
		String s1 = sc.nextLine();
		System.out.println(s1);
		String s2 = sc.nextLine();
		int c2 = Integer.parseInt(s2);
		System.out.println(c2);
	}

}
