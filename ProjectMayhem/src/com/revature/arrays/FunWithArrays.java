package com.revature.arrays;

import java.util.Arrays;

public class FunWithArrays {
	public static void main(String[] args) {
		int s = 20;
		//int array with seven 'buckets'
		int[] myArray = new int[s];
		//int array with hard-coded values
		int[] chaos = {3,4,5,7,9,0,8,5,4,1,6};
		System.out.println(chaos[1]);
		
		for(int i = 0; i<myArray.length; i++) {
			myArray[i] = 5*i;
			System.out.println(i+tag(i)+" element is "+myArray[i]);
		}//end for
		for(int x:chaos) {
			System.out.print(x+" ");
		}
		System.out.println();
		System.out.println(Arrays.toString(chaos));
		Arrays.sort(chaos);
		System.out.println(Arrays.toString(chaos));
		
	}//end main
	
	static String tag(int i) {
		String s;
		switch (i%10) {
		case 1:
			s = "st";
			break;
		case 2:
			s = "nd";
			break;
		case 3:
			s = "rd";
			break;
		default:
			s = "th";		
		}
		return s;
	}//end tag
	
}//end FunWithArrays
