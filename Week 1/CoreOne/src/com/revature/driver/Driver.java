package com.revature.driver;

import java.util.Scanner;

public class Driver {
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		// Question 1
		Question1 q1 = new Question1();
		q1.run();

		// Question 2
		Question2 q2 = new Question2();
		q2.prompt();
		System.out.println(q2.run());

		// Question 3
		Question3 q3 = new Question3();
		q3.prompt();
		String str = in.nextLine();
		q3.prompt2();
		System.out.println(q3.run(str));

		// Question 4
		Question4 q4 = new Question4();
		q4.prompt();
		String n = in.nextLine();
		q4.run(n);

		// Question 5
		Question5 q5 = new Question5();
		q5.prompt1();
		String index = in.nextLine();
		if (q5.validIndex(index)) {
			q5.prompt2();
			String s = in.nextLine();
			String sub = q5.run((int)Double.parseDouble(index), s);
			System.out.println(sub);
		} else {
			System.out.println("invalid index value");
		}
		// Question 6
		String even;
		Question6 q6 = new Question6();
		q6.prompt();
		even = in.nextLine();
		q6.run(even);

		// Question 7
		Question7 q7 = new Question7();
		q7.prompt();
		q7.run();

		// Question 8
		Question8 q8 = new Question8();
		q8.run();

		// Question 9
		Question9 q9 = new Question9();
		q9.run();

		// Question 10
		Question10 q10 = new Question10();
		q10.prompt();
		String min1 = in.nextLine();
		q10.prompt2();
		String min2 = in.nextLine();
		System.out.println("Solution:" + Question10.getMin(min1, min2));

		// Question 11
		Question11 q11 = new Question11();
		q11.prompt();
		float[] gottem = q11.run();
		System.out.println(gottem[0] + " & " + gottem[1]);

		// Question 12
		Question12 q12 = new Question12();
		q12.prompt();
		System.out.println(q12.getEvens());

		// Question 13
		Question13 q13 = new Question13();
		q13.prompt();
		System.out.println(Question13.printTriangle());

		// Question 14
		Question14 q14 = new Question14();
		q14.prompt();
		String choice = in.nextLine();
		System.out.println(q14.run(choice));
		// Question 15
		Question15 q15 = new Question15();
		q15.prompt();
		System.out.println("2 + 4 is " + q15.addition(2, 4));
		System.out.println(("4 / 6 is " + q15.division(4, 6)));

		// Question 16
		Question16.main(args);
		
		//Question 17
		Question17.run();
		
		//Question 18
		Question18 q18 = new Question18();
		q18.prompt();
		// in.close();

	}

}
