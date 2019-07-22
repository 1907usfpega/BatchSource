package com.revature.work;

public class BubbleSort {

	//sorts an array using the bubble sort method
	public static int[] dance(int ... orig){
		boolean sorted=false;
		while(!sorted) {
			sorted=true;
			for (int j=0;j<orig.length-1;j++) {
				if (orig[j]>orig[j+1]) {
					int temp=orig[j+1];
					orig[j+1]=orig[j];
					orig[j]=temp;
					sorted=false;
				}
			}			
		}
		return orig;
	}
	
}
