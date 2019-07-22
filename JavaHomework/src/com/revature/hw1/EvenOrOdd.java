package com.revature.hw1;

public class EvenOrOdd {

	   public static void main(String[] args) {

	        int num=11;
	        System.out.println("Number: " + 11);
	        checkEven(num);

	    }

	    static void checkEven(int num){
	        //divide the number by two
	        //since its an integer decimals will be truncated
	       int n = num/2;
	       // then multiply the top number by two
	       int answer = n*2;

	       //compare the original number and the answer if they match they are even, if not they odd
	       if (num == answer)
	       {
	           System.out.println("Even");
	       }
	       else{
	           System.out.println("NotEven");
	       }

	    }


	}