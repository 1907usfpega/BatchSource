package com.revature.hw1;

import java.util.Scanner;

public class NFactorial {
	
	public static int factorialize(int i) {
		if (i == 1) {
			System.out.println(i);
			return 1;
		}
		
		int result = i * (i - 1);
		for(int j = i - 2; j > 0; j--) {
			result = result * j;
		}
		
		return result;
	}

}