package com.revature.homework1;

public class Assignment4 {
	public static int factorialCheck(int x){
		if (x==1){
			return 1;
		}else{
			return x * factorialCheck(x-1);
		}
	}

}
