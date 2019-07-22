package com.revature.hw1;

import java.util.ArrayList;

public class ArrayPrimeList {

    public static void main(String[] args) {

        ArrayList<Integer> myList = new ArrayList<Integer>();
        ArrayList<Integer> myPrimes = new ArrayList<Integer>();
        ArrayList<Integer> notPrimes = new ArrayList<Integer>();
        for (int i = 1; i <= 100; i++) {
            myList.add(i);
        }

        //System.out.println(myList);

        for (int primes : myList) {

            //boolean to check if it is a prime
            boolean boolPrime = isPrime(primes);

            //if it is a palindrome
            if (boolPrime) {
                //adds the num word to the prime Arraylist
            //System.out.println("prime: "+primes);
                myPrimes.add(primes);
            } else {
                //adds the non to the prime ArrayList
            //System.out.println("Not: "+primes);
                notPrimes.add(primes);
            }
        }

        //print out the list to the console
        System.out.println("NotPrimes List: ");
        System.out.println(notPrimes);

        System.out.println("Primes list: ");
        System.out.print(myPrimes);

    }


    public static boolean isPrime(int value) {

        //we know these so we can just create them
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
