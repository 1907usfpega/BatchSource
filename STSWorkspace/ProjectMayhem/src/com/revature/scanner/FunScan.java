package com.revature.scanner;

import java.util.Scanner;

public class FunScan 
{
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		String contents;
		System.out.print("What would you like to print?");
		contents = sc.nextLine();
		System.out.println(contents);
		
		System.out.println(" and then? ");
		String s1 = sc.nextLine();//wont read a space if you say next()
		System.out.println(s1);
		
		System.out.println("What whole number? ");
		String s2 = sc.nextLine();
		int i = Integer.parseInt(s2);
		System.out.println(i);
	}

}
