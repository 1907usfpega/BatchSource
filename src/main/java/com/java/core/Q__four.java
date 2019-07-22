package com.java.core;

import java.util.Scanner;

public class Q__four {
//Q4. Write a program to compute N factorial.
	Scanner sc = new Scanner(System.in);
	public static int N=5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
    System.out.println("Factorial of "+ N + " is "+ factorial(N));
	}
	
	
	
	
static int factorial(int N) {
	if (N == 0) 
        return 1; 
        
      return N*factorial(N-1);
}
}
