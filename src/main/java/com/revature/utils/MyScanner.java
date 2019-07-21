package com.revature.utils;

import java.util.Scanner;

public class MyScanner {
	// obj to receive user inputs
	public static Scanner sc = new Scanner(System.in);

	public static double getDouble() {
		do {
			String s1 = sc.nextLine();
			try { 				
				return Double.parseDouble(s1);
			} catch (Exception e) {
				System.out.print("\nInput is not double. " 
									+ "Please try again: ");
				}

		} while (true);
	}
	
	public static int getInteger() {
		do {
			String s1 = sc.nextLine();
			try { 				
				return Integer.parseInt(s1);
			} catch (Exception e) {
				System.out.print("\nInput is not an integer. " 
									+ "Please try again: ");
				}

		} while (true);
	}
}
