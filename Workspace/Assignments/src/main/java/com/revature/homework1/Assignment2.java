package com.revature.homework1;

public class Assignment2 {
	public static int[] fibMethod(int[] fNum){
		fNum[0] = 0;
		fNum[1] = 1;
		for (int i = 2; i < fNum.length; i++) {
			fNum[i] = fNum[i - 2] + fNum[i-1];
			
		}
		for (int newArr: fNum){
			System.out.println(newArr);
		}
		
		return fNum;
		
		
		
		}

	@Override
	public String toString() {
		return "Assignment2 [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
		
	}


