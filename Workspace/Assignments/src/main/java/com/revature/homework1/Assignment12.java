package com.revature.homework1;

public class Assignment12 {
	public static int arrayNumberCheck(int[] myArray){
		int trans = 0;
		for (int i = 1; i < myArray.length +1; i++){
			
			myArray[i-1] = i;
			
			
			
		}
		for (int arr:myArray){
			if(arr % 2 == 1)
				continue;
			System.out.println(arr);
			trans = arr;
			
	}
		return trans;
		

}

}
