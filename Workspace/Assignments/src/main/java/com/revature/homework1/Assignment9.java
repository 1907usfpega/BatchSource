package com.revature.homework1;

import java.util.ArrayList;

public class Assignment9 {
	public static ArrayList<Integer> primeNumberCheck(){
		ArrayList<Integer> myList = new ArrayList<Integer>();
		ArrayList<Integer> myPrimeList = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			myList.add(i+1);
		}
		
		for(Integer primeChecker: myList){
			if (isPrimeNumber(primeChecker)){
				myPrimeList.add(primeChecker);
			}
		}
		
		return myPrimeList;
		
	}//end 
	
	public static boolean isPrimeNumber(Integer number){
		boolean isPrime = true;
		
		if(number ==1){
			isPrime = false;
		}
		for(int divisor = 2; divisor <= number/2; divisor++ ){
			if (number % divisor == 0){
				isPrime = false;
				break;
			}
		}
		return isPrime;
		
	}

}
