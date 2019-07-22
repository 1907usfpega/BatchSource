package com.revature.flows;

import com.revature.beans.Person;

public class LoopyLoops {

	public static void main(String[] args) {

		//whatColor("green");
		//whatColor("blasgj");
		//forLoopFunness(30);
		//forEachFun(myArray);
		//whileyWhile(-34);
		//doWhileyWhile(0);
		Person a = new Person("Matt",33,270);
		Person b = new Person("Jason",45,900);
		Person c = new Person("Matt",33,270);
		checkStuff(a,b);
		checkStuff(a,c);
		checkStuff(a,a);
	}

	static String color;

	// switch
	public static void whatColor(String color) {
		switch (color) {
		case "green":
			System.out.println("yo, the color is green, dog");
			break;
		case "orangered":
			System.out.println("what just happened");
			break;
		case "purple":
			System.out.println("Purple is pretty kewl");
			break;
		case "puce":
			System.out.println("blegh");
			break;
		default:
			System.out.println(color + " is not a creative color.");
		}// end switch
	}// end whatColor

	// for loops
	public static void forLoopFunness(int p) {
		for (int i = p; i > 0; i--) {
			if(i==10) {
				//break and continue
				//break;
				continue;
			}//end if
			System.out.println(i);
		} // end for

	}// end forLoopFunness
	
	static int [] myArray = {12,12,3,4,35,6,7,8,8,9};
	
	public static void forEachFun(int[] a) {
		for(int i:a) {
			System.out.print(i+" ");
		}
	}//end foreachfun
	
	public static void whileyWhile(int i) {
		while(i++<10) {
			System.out.println("man this is so exciting... not "+i);
			//i++;
		}
		
	}//end whileyWhile
	
	public static void doWhileyWhile(int i) {
		do {
			System.out.println("still boring "+i); 
			i++;
		}while(i<10);
	}//end doWhileyWhile
	
	public static void checkStuff(int a, int b) {
		if(a==b)
		{
			System.out.println("same");
		}
		else {
			System.out.println("not same");
		}
	}//end checkStuff
	
	public static void checkStuff(Person s, Person t) {
		System.out.println(s);
		System.out.println(t);
		if(s==t) {
			System.out.println("same reference");
		}
		else {
			System.out.println("not same reference");
		}
		if(s.equals(t)){
			System.out.println("same");
		}
		else {
			System.out.println("not same");
		}
	}

}
