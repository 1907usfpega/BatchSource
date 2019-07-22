package com.revature.homework1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Assignment14 {
	 public static int number = 27;
	    public static String string = "I am learning Core Java";
	 
	    public static void doTask(int x) {
	        switch (x) {
	        case (1):
	            System.out.println("The square-root of " + number + " is " + getSqrt(number));
	            break;
	        case (2):
	            System.out.println(getDate());
	            break;
	        case (3):
	            System.out.println(
	                    "\"" + string + "\" was now split into \"" + splitString()[0] + "\" - and - \"" + splitString()[1]+ "\"");
	        }
	    }
	 
	    public static double getSqrt(int number) {
	        return Math.sqrt(number);
	    }
	 
	    public static String getDate() {
	        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	        LocalDateTime now = LocalDateTime.now();
	        return dtf.format(now);
	    }
	 
	    public static String[] splitString() {
	        String[] halves = new String[] {string.substring(0, string.length() / 2), string.substring(string.length() / 2, string.length())};
	        return halves;
	    }
	}
	





