package com.revature.varargs;

public class Overloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double dub = 2.2;
		int i = 1;
		Integer bigI = 10;
		short lil = 9;
		myNum(i);				// exact match
		myNum(dub);				// boxing
		myNum((double) bigI);	//for the lolz
		myNum(bigI, 2, 3, 4);	//varargs
		System.out.println();
		myNum(lil);				//conversion
		
		
				

	}
	static void myNum(int a) {
		System.out.println(a+ "is my int");
	}
	
	static void myNum(Double a) {
		System.out.println(a+ "is my Double");
	}
	
	static void myNum(int ... v) {
		//For each Loop
		for(int x: v) {
			System.out.print(", " +x);
		}
	}
	
	

}
