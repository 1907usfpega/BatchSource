package com.revature.questions;

import java.awt.font.NumericShaper;
import java.util.Scanner;

public class Question17 {
	
	public static int doTask() {
		Scanner cs = new Scanner(System.in);
		System.out.println("To calculate Interest, first enter your prinicipal now: ");
		String nextLine = cs.nextLine();
		int principal = toInt(nextLine);
		System.out.println("To calculate Interest, enter your rate now: ");
		nextLine = cs.nextLine();
		int rate = toInt(nextLine);
		System.out.println("To calculate Interest, first enter the time next: ");
		nextLine = cs.nextLine();
		int time = toInt(nextLine);
		System.out.println("Your Interest is " + principal*rate*time);
		return principal*rate*time;
	}
	public static int toInt(String str) {
		try {
			 return Integer.parseInt(str);
			}catch(NumberFormatException e) {
				System.out.println("Please restart the programm and enter real numbers!");
			}
		return -1;
	}
}
