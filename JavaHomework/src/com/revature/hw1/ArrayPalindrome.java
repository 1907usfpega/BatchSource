package com.revature.hw1;
import java.util.ArrayList;

public class ArrayPalindrome {

    public static void main(String[] args) {


        ArrayList<String> myList = new ArrayList<String>();
        ArrayList<String> myPalindromes = new ArrayList<String>();
        ArrayList<String> noPalindromes = new ArrayList<String>();
        myList.add("karan");
        myList.add("madam");
        myList.add("tom");
        myList.add("civic");
        myList.add("radar");
        myList.add("jimmy");
        myList.add("kayak");
        myList.add("john");
        myList.add("refer");
        myList.add("billy");
        myList.add("did");


        for (String palin: myList) {

            //boolean to check if it is a palindrome
           boolean palindrome = isPalindrome(palin);

           //if it is a palindrome
           if(palindrome)
           {
               //adds the palindrome word to the palindrome Arraylist
               myPalindromes.add(palin);
           }
           else{
               //adds the non palindrome to the NonPalindrome ArrayList
               noPalindromes.add(palin);
           }
        }
        //print out the list to the console
        System.out.println("Original List: ");
        System.out.println(myList);

        System.out.println("Palindrome list: ");
        System.out.print(myPalindromes);

    }


    public static boolean isPalindrome(String value) {
        if (value == null || value.isEmpty())
            return false;

        // this take the string passed it reverses it and compares if its equal to itself
        //it returns a boolean
        return new StringBuilder(value).reverse().toString().equals(value);
    }


}

