package com.java.core;

public class Q__two {
//Q2. Write a program to display the first 25 Fibonacci numbers beginning at 0.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k,a=1,b=1;
		k=0;
		System.out.print("1 1 ");
		while(k<=46368)
		{
		    k=a+b;
		    System.out.print(k + " ");
		    a=b;
		    b=k;
		}
		    }

	}


