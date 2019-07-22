package com.revature.hw1;
import java.lang.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SwitchDate {
	public static void main(String[] args) {

        //this is how you would pick the case
        int pick = 1;

        //variable for the square root
        int number = 144;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        //switch statement
        switch (pick) {
            case 1:
                System.out.println("Square Root of Number: "+number + " is: "+ Math.sqrt(number));
                break;
            case 2:
                System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
                break;
            case 3: String myString = "I am learning Core Java";
                   String[] spString = myString.split("");
                printArray(spString);
        }
    }

    //print the array sequence
    static void printArray(String myArray[])
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
