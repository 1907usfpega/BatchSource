package com.revature.hw1;

public class TwoNumbers {

	public static void main(String[] args) {
		

        int val1 = 10;
        int val2 = 12;
        System.out.println("The minimum value of "+val1+" and "+val2+" is: ");
        int minVal = (val1 < val2) ? val1 : val2;
        System.out.println(minVal);
    }
}