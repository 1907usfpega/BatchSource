package com.meschac.mafoula;

import java.util.ArrayList;
import java.util.Iterator;

public class Question19 {
	
	public ArrayList<Integer> q19() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> returnValues = new ArrayList<Integer>();
		int result = 0;
		for (int i=1; i<=10; i++) {
			arr.add(i); //insert elements into array
		}
		returnValues.addAll(arr);
		for (int i=1; i<arr.size(); i+=2) { //size returns number of elements in list
			//start at 1 because arr[1]=2
				//Since 1 is at index 0, all the odd numbers will be at an even index
				result += arr.get(i); //get value at arr[i] and increment result by arr[i]
		}
		System.out.println(result);
		returnValues.add(result); //add even sum to returnValues
		result = 0; //reset result
		for (int i=0; i<arr.size(); i+=2) { //size returns number of elements in list
			//start at 0 because arr[0]=1	
			//Since 1 is at index 0, all the odd numbers will be at an even index
			result += arr.get(i); //get value at arr[i] and increment result by arr[i]
			}
		System.out.println(result);
		returnValues.add(result); //add odd sum to returnValues
		
		//Begin removal of primes
		//Remove {1, 2, 3, 5, 7,}
		ArrayList<Integer> primes = new ArrayList<Integer>();
		Iterator itr = arr.iterator();
		while (itr.hasNext()) {
			//cast to int from Integer
			int n = (int) itr.next();
			boolean isPrime =com.meschac.mafoula.Isprime.Isprime.isPrime(n);
			if (isPrime) {
				primes.add(n);
			}
		}
		//Add in difference update here
		itr = primes.iterator();
		while(itr.hasNext()) {
			arr.remove(itr.next()); //remove Integer object that matches
		}
		System.out.println(arr);
		returnValues.addAll(arr); //append remaining composite numbers to returnValues
		return returnValues;
	}


}
