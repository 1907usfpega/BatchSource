package com.revature.questions;

import java.util.Arrays;

public class Question2 {
	static int[] fibos = new int[25];
	public static int[] doTask(){
		for (int i = 0; i < fibos.length; i++) {//for 23 times, it will add the last two fibos to create the current one. First two are 0 & 1
			if(i==0 || i==1) {
				fibos[i] = 1;
				continue;
			}
			fibos[i] = fibos[i-1] + fibos[i-2];
		}
		//System.out.println(Arrays.toString(fibos));
		return fibos;
	}
}
