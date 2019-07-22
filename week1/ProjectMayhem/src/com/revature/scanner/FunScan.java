package com.revature.scanner;

import java.util.Scanner;

public class FunScan {
	public static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		String message;
		System.out.println("Enter Something: ");
		message=sc.nextLine();
		System.out.println(message);
		System.out.println("what else?");
		message=sc.nextLine();
		System.out.println(message);
		System.out.println("how bout some ints?");
		message=sc.nextLine();
		int a=Integer.parseInt(message);		
		System.out.println(a);
		
	}

}
