package com.revature.hw1;

public class CommandLine {


    public static void main(String[] args) {

        for (String arg: args) {
            System.out.print("The number of characters in the String " + arg + " is: ");
            System.out.println(arg.length());
        }
    }

}
