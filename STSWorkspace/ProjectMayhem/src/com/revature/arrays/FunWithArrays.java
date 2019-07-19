package com.revature.arrays;

import java.util.Arrays;

public class FunWithArrays {

	public static void main(String[] args) 
	{
		int s =7;
		int[] myArray = new int[s];
		int[] chaos = {1,2,3,5,4,6,7,8,9,10};
		//System.out.println(chaos[1]);
		
		/*for(int i = 0; i < myArray.length; i++)
		{
			myArray[i] = i*5;
			System.out.println(i+" element is "+myArray[i]);
		}
		for(int i : chaos)
		{
			System.out.println(i);
		}*/
		System.out.println(Arrays.toString(chaos));
		Arrays.sort(chaos);
		System.out.println(Arrays.toString(chaos));
		
		
	}

}
