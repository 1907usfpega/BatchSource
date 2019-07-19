package com.revature.questions;
//Q2. Write a program to display the first 25 Fibonacci numbers beginning at 0.
public class Q2 {

	public static void main(String[] args) {
		//set initial values
		int prev = 0;
		int num = 0;
		int next = 1;
		
		int count = 0;
		
			//using DO to execute one time printing 0
			do {
				System.out.print(num+" ");
				prev = num;
				num = next;
				//sum last two values to print next
				next = prev+num;
				
				count++;
			}
			//executes 25times
			while(count < 25);

	}

}
