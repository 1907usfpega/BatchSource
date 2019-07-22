package com.java.core;

import java.util.ArrayList;

public class Evens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  ArrayList<Integer> intList = new ArrayList<Integer>();
          double evenSum = 0;
          double oddSum = 0;
          for (int i = 1; i <= 10; i++) {
              intList.add(i);
          }
          System.out.println("This is my arrayList populated with integers 1 through 10: " + intList);
          boolean evenGo = true;
          boolean oddGo = true;
          for (int i = 0; i < intList.size(); i++) {
              //checks if elements form the original list are even
              int checkEvenOrOdd = isEvenOdd(intList.get(i));
              if (checkEvenOrOdd == 1) {
                  while(evenGo){
                      System.out.print("Even: ");
                      evenGo =false;
                  }
                  System.out.print(intList.get(i)+ " ");
                  evenSum += intList.get(i);
              }
          }
          System.out.println(" Even Sum: " + evenSum);
          for (int i = 0; i < intList.size(); i++) {
              //checks if elements form the original list are odd
              int checkEvenOrOdd = isEvenOdd(intList.get(i));
              if (checkEvenOrOdd == 0) {
                  while(oddGo){
                      System.out.print("Odd: ");
                      oddGo =false;
                  }
                  System.out.print(intList.get(i)+ " ");
                  oddSum += intList.get(i);
              }
          }
          System.out.println("Odd Sum: " + oddSum);
          for (int i = 0; i < intList.size(); i++) {
              boolean boolPrime = isPrime(intList.get(i));
              if (!boolPrime) {
                 intList.remove(i);
              }
          }
          System.out.println("Not Prime: " + intList);
          }
      public static int isEvenOdd(int value) {
          if(value % 2 == 0)
          {
              return 1;
          }
          else {
              return 0;
          }
      }
      public static boolean isPrime(int value) {
           //This will check for prime numbers
          if(value == 1 || value == 0) return false;
          if(value == 2) return true;
          //check if n is a multiple of 2
          if (value % 2 == 0) return false;
          //if not, then just check the odds
          for (int i = 3; i * i <= value; i += 2) {
              if (value % i == 0)
                  return false;
          }
          return true;

		
		
		
		
	}

}
