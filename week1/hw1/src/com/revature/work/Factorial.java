package com.revature.work;

public class Factorial {

	//returns n!
	public static int fact (int a) {
		if (a<=1)
			return 1;
		else
			return a*fact(a-1);
	}

}
