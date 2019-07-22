package com.revature.driver;

import java.util.ArrayList;

import com.revature.comp.EmployeeMain;
import com.revature.faces.InterImp;
import com.revature.subclass.Concrete;
import com.revature.work.Args;
import com.revature.work.ArrayListManip;
import com.revature.work.BubbleSort;
import com.revature.work.EvenWithoutMod;
import com.revature.work.Evens;
import com.revature.work.Factorial;
import com.revature.work.Fibbonacci;
import com.revature.work.Floats;
import com.revature.work.FromFile;
import com.revature.work.Interest;
import com.revature.work.Palindromes;
import com.revature.work.Primes;
import com.revature.work.Reverse;
import com.revature.work.SubString;
import com.revature.work.Switch;
import com.revature.work.Ternary;
import com.revature.work.Triangle;

public class Driver {

	public static void main(String[] args) {
		//Q1
		System.out.println("QUESTION 1");
		System.out.println("Original: ");
		int[] a= {1,0,5,6,3,2,3,7,9,8,4};
		for (int x: a) {
			System.out.print(x+" ");
		}
		System.out.println("\n"+"Sorted: ");
		BubbleSort.dance(a);
		for (int x: a) {
			System.out.print(x+" ");
		}
		
		//Q2
		System.out.println("\n\nQUESTION 2");
		System.out.println("Fibbonacci to 25th:");
		for (int i=0; i<=25; i++) {
			System.out.print(Fibbonacci.fibb(i)+" ");
		}
		
		//Q3
		System.out.println("\n\nQUESTION 3");
		Reverse.turnAround("Homeowner");
		
		
		//Q4
		System.out.println("\n\nQUESTION 4");
		System.out.print("Factorial of 5: ");
		System.out.println(Factorial.fact(5));
		
		
		//Q5
		System.out.println("\nQUESTION 5");
		System.out.println("the first 18 letters of supercalifragilisticexpialidocious are:");
		char[] b=SubString.shortString("supercalifragilisticexpialidocious",18);
		for (char x: b) {
			System.out.print(x);
		}
		
		//Q6
		System.out.println("\n\nQUESTION 6");
		System.out.print("54 is: ");
		EvenWithoutMod.ewm(54);
		System.out.print("87 is: ");
		EvenWithoutMod.ewm(87);
		
		//Q7
		System.out.println("\nQUESTION 7");
		EmployeeMain.sorts();
		
		//Q8
		System.out.println("\nQUESTION 8");
		ArrayList<String> al = new ArrayList<String>();
		al.add("karan"); al.add("madam"); al.add("tom");
		al.add("civic"); al.add("radar"); al.add("jimmy");
		al.add("kayak"); al.add("john"); al.add("refer");
		al.add("billy"); al.add("did");
		Palindromes.pals(al);
		
		//Q9
		System.out.println("\n\nQUESTION 9");
		System.out.println("Primes from 1-100: ");
		Primes.printPrime();

		//Q10
		System.out.println("\n\nQUESTION 10");
		System.out.println("Min of 1 & -12: "+Ternary.min(1,-12));
		System.out.println("Max of 25 & 2: "+ Ternary.max(25,2));
		
		//Q11
		System.out.println("\nQUESTION 10");
		System.out.println("Access 2 floats from a separate package:");
		Floats f=new Floats(69,420);
		System.out.println("a= "+f.getA()+" b= "+f.getB());
		System.out.println("b/a= "+f.getB()/f.getA());
		
		//Q12
		System.out.println("\nQUESTION 12");
		System.out.println("Evens from 1-100: ");
		Evens.printEven();
		
		//Q13
		System.out.println("\n\nQUESTION 13");
		Triangle.tri();
		
		//Q14
		System.out.println("\nQUESTION 14");
		Switch.switchCase(1);
		Switch.switchCase(2);
		Switch.switchCase(3);
		Switch.switchCase(0);
		
		//Q15
		System.out.println("\nQUESTION 15");
		InterImp d=new InterImp();
		System.out.println("Add 1+2: "+d.addition(1,2));
		System.out.println("Div 4/2: "+d.division(4, 2));
		System.out.println("Mult 3*2: "+d.multiplication(3,2));
		System.out.println("Sub 4-3: "+d.subtraction(4, 3));
		
		//Q16
		System.out.println("\nQUESTION 16");
		Args.attempt(args[0]);
		
		
		//Q17
		System.out.println("\nQUESTION 17");
		System.out.println(Interest.simpleInterest());
		
		//Q18
		System.out.println("\nQUESTION 18");
		Concrete con=new Concrete("Safety");
		if (con.checkUpper()) {
			System.out.println(con.getS()+" has a Capital letter");
		}
		String n =con.convertUpper();
		System.out.println(n+" Has been capitalized");
		System.out.println("The int value of "+con.getS()+"+10 is:");
		con.convertInt();
		
		
		//Q19
		System.out.println("\nQUESTION 19");
		System.out.println("Manipulating an ArrayList: ");
		ArrayListManip.ALManip();

		//Q20
		System.out.println("\n\nQUESTION 20");
		System.out.println("Data from File");
		FromFile.read();
	}

}
