package com.revature.driver;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// Question 1
		Question1 q1 = new Question1();
		q1.run();

		// Question 2
		Question2 q2 = new Question2();
		q2.run();

		// Question 3
		Question3 q3 = new Question3();
		q3.prompt();
		System.out.println(q3.run("hello"));
		// Question 4
		Question4 q4 = new Question4();
		q4.prompt();
		int n = in.nextInt();
		q4.run(n);

		// Question 5
		Question5 q5 = new Question5();
		q5.prompt1();
		int index = in.nextInt();
		q5.prompt2();
		String s = in.next();
		String sub = q5.run(index, s);
		System.out.println(sub);

		// Question 6
		Question6 q6 = new Question6();
		q6.prompt();
		n = in.nextInt();
		q6.run(n);

		// Question 7

		// Question 8
		Question8 q8 = new Question8();
		q8.run();

		// Question 9
		Question9 q9 = new Question9();
		q9.run();

		// Question 10

		// Question 11
		Question11 q11 = new Question11();
		q11.prompt();
		float[] gottem = q11.run();
		System.out.println(gottem[0] + " & " + gottem[1]);

		// Question 12
		Question12 q12 = new Question12();
		q12.prompt();
		q12.init();
		q12.printEvens();

		// Question 13
		Question13 q13 = new Question13();
		q13.prompt();
		q13.printTriangle();
		
		//Question 14
		

		in.close();

	}

	// QUESTION 7

	// QUESTION 10

}
