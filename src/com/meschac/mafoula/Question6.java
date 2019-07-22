package com.meschac.mafoula;
import java.lang.Math;

public class Question6 {
	public static boolean q6(int n) {
		n = Math.abs(n); //Make it absolute so it'll work with negative numbers
		double d = n; //Cast to double so you'll get decimals if it's odd
		if (d == 0) {
			System.out.println("Even");
			return true; //prevents method from going to the else block
		}
		
		d = d/2;
		//if floor = d after dividing by 2; then there is no decimal & it's even
		if(d == Math.floor(d)) {
			System.out.println("Even");
			return true;
		}
		else {
			System.out.println("Odd");
			return false;

}}}
