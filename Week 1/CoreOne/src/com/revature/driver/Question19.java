package com.revature.driver;

import java.util.ArrayList;
import java.util.List;

public class Question19 {
	public List<Integer> arrList = new ArrayList<Integer>(); 
	//constructor the init's arrList to hold values from 1-10
	public Question19() {
		for(int i = 1; i < 11; i++) {
			arrList.add(i);
		}
	}
	public ArrayList<Integer> getAllEven() {
		ArrayList<Integer> even = new ArrayList<Integer>();
		for(int i = 1; i < 11; i++) {
			if(i%2 == 0) {
				even.add(i);
			}
		}
		return even;
	}
	
	public ArrayList<Integer> getAllOdd(){
		ArrayList<Integer> odd = new ArrayList<Integer>();
		for(int i = 1; i < 11; i++) {
			if(i%2 == 1) {
				odd.add(i);
			}
		}
		return odd;
	}
	public ArrayList<Integer> getNotPrimes() {
		String primes = Question9.getPrimes(arrList);
		ArrayList<Integer> notPrimes = new ArrayList<Integer>();
		for(int i = 1; i < 11; i++) {
			if(!primes.contains(i+"")) {
				notPrimes.add(i);
			}
		}
		return notPrimes;
	}
	
	public static int addIntegerInArrList(ArrayList<Integer> arr) {
		int value = 0; 
		for(int i: arr) {
			value+=i;
		}
		return value;
	}
	protected void prompt() {
		System.out.println("Question 19:\nSolution:\n");
	}
}
