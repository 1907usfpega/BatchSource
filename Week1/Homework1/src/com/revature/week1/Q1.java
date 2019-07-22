package com.revature.week1;

import java.util.List;

public class Q1 {
	public int[] bubbleList = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
	
	public static int [] bubbleSort=(int[] List)
	{
		int i = 0; // outer loop
		int j = 0; // inner loop
		int temp=0; //temp variable
		
		for(i=0;i<List.length-1;i++) {
			for(j=0;j<List.length-1-i;j++) {
				if(List[j]>List[j+1]) {
					temp=List[j];
					List[j]=List[j+1];
					List[j+1]=temp;
				}
			}
		}
		
	}
	
	return list;
}
