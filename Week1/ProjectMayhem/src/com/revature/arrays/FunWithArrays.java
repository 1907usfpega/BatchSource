package com.revature.arrays;

import java.util.Arrays;

public class FunWithArrays {
	//group of like-typed variables that are referred to by a common name
	public static void main(String[] args) {
		int s=7;
		//int array w/ 7 "buckets"
		int [] myArray= new int[s];
		//int myArray[]= new int[s]; <- still cool
		//in array w/ hardcoded values
		int [] chaos= {3,5,6,3,6,2,664,345,224,7663};
		System.out.println(chaos[1]);
		//System.out.println(chaos);
		for (int i=0;i<myArray.length;i++) {
			myArray[i]=i*5;
			//System.out.println(i+" element is "+ myArray[i]);
		}
		for (int i:chaos) {
			System.out.println(i);
		}

		System.out.println(Arrays.toString(chaos));
		Arrays.sort(chaos);
		System.out.println(Arrays.toString(chaos));
	}

}
