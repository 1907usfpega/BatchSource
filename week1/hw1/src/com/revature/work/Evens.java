package com.revature.work;

import java.util.ArrayList;

public class Evens {
	public static ArrayList<Integer> printEven() {
		ArrayList<Integer> a=new ArrayList<Integer>();
		for(int i=1;i<=100;i++) {
			a.add(i);
		}
		for(int i: a) {
			if (i%2==0) {
				System.out.print(i+" ");
			}
		}
		return a;
	}
}
