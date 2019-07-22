package com.revature.work;

public class Fibbonacci {

	//returns the value at the index in the fibb sequence
	public static int fibb (int a) {
		if (a<=1)
			return a;
		else
			return fibb(a-1)+fibb(a-2);
	}
}
