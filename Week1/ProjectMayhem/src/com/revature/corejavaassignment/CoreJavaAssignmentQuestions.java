package com.revature.corejavaassignment;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class CoreJavaAssignmentQuestions {
	public static void main(String []args) throws IOException {
		Q1 myQ1 = new Q1();
		Q2 myQ2 = new Q2();
		Q3 myQ3 = new Q3();
		Q4 myQ4 = new Q4();
		Q5 myQ5 = new Q5();
		Q6 myQ6 = new Q6();
		Q7 myQ7 = new Q7();
		Q8 myQ8 = new Q8();
		Q9 myQ9 = new Q9();
		Q10 myQ10 = new Q10();
		Q11 myQ11 = new Q11();
		Q12 myQ12 = new Q12();
		Q13 myQ13 = new Q13();
		Q14 myQ14 = new Q14();
		Q15 myQ15 = new Q15Class();	
		
//args defined under Run->Run Configurations->Arguments
		
		Q16 myQ16 = new Q16(args);
		Q17 myQ17 = new Q17();
		
		Q18 myQ18 = new Q18();
		System.out.println("True or false...");
		System.out.println("\"Apple\" has uppercase letters. " + 
							myQ18.uppercaseTest("Apple"));
		System.out.println("\"apple\" has uppercase letters. " + 
				myQ18.uppercaseTest("apple"));
		System.out.println(
				);
		System.out.println("\"AbCdEfG\""
				+ "\" converted to uppercase is: " +
				myQ18.uppercaseConvert("AbCdEfG"));
		System.out.println("\"126\" plus 10 = " + 
				myQ18.addTen("126"));
		System.out.println("\n\n");
		
		Q19 myQ19 = new Q19();
		Q20 myQ20 = new Q20();
		System.out.println("**************************\n"
				+ "********** DONE **********\n"
				+ "**************************");
		
	}
	public CoreJavaAssignmentQuestions() {
	}
	

}
