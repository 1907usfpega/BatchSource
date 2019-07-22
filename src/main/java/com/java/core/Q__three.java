package com.java.core;

public class Q__three {
//Q3. Reverse a string without using a temporary variable.  Do NOT use reverse() in the 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
String Rev= "abcdefghijklmnop";
char Array[];
Array = new char[Rev.length()];
for(int x = 0;x<Rev.length();x++) {
	Array[x]=Rev.charAt(x);
	
}
for(int x = Rev.length()-1;x>=0;x--) {
	System.out.print(Array[x]);
}
	}

}
