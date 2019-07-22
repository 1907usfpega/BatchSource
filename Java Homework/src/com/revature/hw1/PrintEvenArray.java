package com.revature.hw1;

public class PrintEvenArray {
	public static void main(String[] args) {

        int arraySize = 100;
        int[] myArray = new int[arraySize];

        //populate array with numbers 1 to 100
        for(int i=0; i < myArray.length;i++){
            myArray[i]=i+1;  //add one because we want to just store the 1 -> 100
        }

       //iterate through array and find the even numbers using for each loop
        for (int even : myArray) {
            //if the value is divisible by two then its even
            if(even % 2 == 0)
            {
                System.out.println("Even: " +even);
            }
        }

    }
    //print the array sequence
    static void printArray(int myArray[])
    {
        //get array length
        int n = myArray.length;
        //iterate through array and print it out
        for (int i=0; i<n; ++i) {
            System.out.print(myArray[i] + " ");
        }
        System.out.println();
    }




}
