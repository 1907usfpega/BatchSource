package com.java.core;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Q9. Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.
 * 
 */
public class Q__nine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
        //define limit
        int OneHundred = 100;

        System.out.println("Prime numbers between 1 and " + OneHundred);

        for(int i=1; i < OneHundred; i++){

                boolean Prime = true;

                for(int j=2; j < i ; j++){

                        if(i % j == 0){
                                Prime = false;
                                break;
                        }
                }
                // print the number
                if(Prime)
                        System.out.print(i + " ");
        }//main for loop

	}
			}   
	//loop

	


