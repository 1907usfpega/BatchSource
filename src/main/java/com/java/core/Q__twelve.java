package com.java.core;

import java.util.ArrayList;

//Q12. Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers from the array. 
//Use the enhanced FOR loop for printing out the numbers.
//
public class Q__twelve {
public static ArrayList<Integer>numbers = new ArrayList<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
for(int x =1;x<=100;x++) {
	numbers.add(x);
}
		for(int x:numbers) {
			if(x%2==0)
			System.out.println(x);
		}
		
	}

}
