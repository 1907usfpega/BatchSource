package com.revature.questions;

import java.util.Arrays;

public class Question2 {
	static int[] fibos = new int[25];
	public static int doTask(){
		for (int i = 0; i < fibos.length; i++) {
			if(i==0 || i==1) {
				fibos[i] = i;
				continue;
			}
			fibos[i] = fibos[i-1] + fibos[i-2];
		}
		System.out.println(Arrays.toString(fibos));
		return fibos[24];
	}
}
