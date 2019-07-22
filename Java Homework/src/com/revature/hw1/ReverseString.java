package com.revature.hw1;

public class ReverseString {

	    public ReverseString() { }

	    public static void main(String[] args) {

	        String myString= "JohnMichel";
	        int stringLength = myString.length();
	        System.out.println(myString);
	        String mystring= ReverseString(myString, stringLength);
	        System.out.println(mystring);

	    }
	    static String ReverseString(String str, int stringLength){

	        //first convert the string into a character array
	        char[] charArray = str.toCharArray();

	        //get the length of the string
	        for (int i = 0 ; i < stringLength ; i++) {
	            if(i< stringLength-1){
	                char first = charArray[stringLength-1];
	                char last = charArray[i];
	                charArray[i] = first;
	                charArray[stringLength-1] = last;
	                stringLength--;
	            }
	        }
	        String myString = new String(charArray);

	        return myString;
	    }
	}
