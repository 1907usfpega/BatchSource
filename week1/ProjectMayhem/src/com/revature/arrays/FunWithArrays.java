package com.revature.arrays;

import java.util.Arrays;

public class FunWithArrays {

	public static void main(String[] args) {
		int s= 7;
		int [] a=new int[s];
		//can also hardcode values
		int [] b= {3,213,53,457,23245};
		//System.out.println(b);
		
		for (int i=0;i<a.length;i++) {
			a[i]=i*5;
		}
	
		System.out.println(Arrays.toString(a));
		Arrays.sort(b);
		System.out.println(Arrays.toString(b));
	
	}
}
