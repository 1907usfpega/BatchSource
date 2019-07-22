package com.java.core;

public class Q__five {
/*
 * Q5. Write a substring method that accepts a string str and an 
	integer idx and returns the substring contained between 0 and 
	idx-1 inclusive.  Do NOT use any of the existing substring 
	methods in the String, StringBuilder, or StringBuffer APIs.
	*/
	public static char ring[];
	public static String str="Relaxing";
	public static int idx=6;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		substring(str,idx);
	}
static void substring(String s,int x) {
	ring = s.toCharArray();
	for(int y = 0;y<x;y++) {
		System.out.print(ring[y]);
	}
	
}
}
