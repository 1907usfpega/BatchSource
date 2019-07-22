package com.meschac.mafoula.Isprime;

public class Isprime {
	public static boolean isPrime(int n) {
		if (n==1 || n==2) { //gotta catch the only even prime & prevent dividing by zero
			return true;
		}
		else {
			int divisor = n-1;
			while (divisor>1) {
				if(n%divisor==0) {
					return false;
				}
				divisor--;
				if (divisor==1) {
					return true;
				}
			}
		}
	return false; //Negative numbers don't count
	}

}
