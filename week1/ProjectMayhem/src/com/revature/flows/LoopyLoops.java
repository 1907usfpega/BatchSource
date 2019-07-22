package com.revature.flows;

import com.revature.beans.Person;

public class LoopyLoops {
	static String color;

	public static void main(String[] args) {
		/*if statemenst
		 * for descision making
		 * if(condition)
		 * 	execute
		 * else if (condition)
		 * 	execute
		 * else
		 *  default execution 
		 */
		
		/*switch case
		 * multiple nested if else blocks
		 * use breaks to avoid fall through
		 */
		//whatColor("green");
		
		/*for (int i=20;i>0;i--) {
			if (i==15) {
				continue;//skips to next increment
			}
			
			if (i==10) {
				break;//quits entirely
			}
			System.out.println(i);
		}*/
		//forEachFun(myArray);
		//func(2);
		Person a = new Person ("matt",23,243);
		Person b = new Person ("matt",23,243);
		checkStuff(a,b);
	}
	public static void whatColor(String color) {	
		switch(color) {
		case "green":
			System.out.println("color is green");
			break;
		case "blue":
			System.out.println("color is blue");
			break;
		case "purple":
			System.out.println("color is purple");
			break;
		case "puce":
			System.out.println("color is ugly");
			break;
		default:
			System.out.println("you just had to be special?");
		}
	}
	
	static int [] myArray= {3,6,9,12};
	public static void forEachFun(int [] a) {
		for(int i: a) {
			System.out.println(i);
		}
	}
	
	//while(condition){execute}
	//do while executes once if false
	//while never executes if false
	//do {execute} while (condition);
	public static void func (int i) {
		while (i<10) {
			System.out.println("hummighannamimignana");
			i++;
		}
		do {System.out.println("get dunked on");}while(i-->0);
	}
	
	public static void checkStuff(Person s, Person t) {
		if (s.equals(t)){
			System.out.println("same");
		}
		else {
			System.out.println("not same");
		}
	}

}
