package com.revature.hw1;

public class Q6 {
	
	//Q6: Tests whether ints are even without mod command.
	//Concept: Continue to divide by two, and if double val
	//divides into 1.0, then value is even. Invalidated by Integer
	//method.
		public static boolean evenFlow(Integer a)
		{
			
			if(Integer.remainderUnsigned(a, 2) == 0)
			{
				return true;
			}
			
			else return false;	
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
