package com.revature.flows;

import java.util.zip.Checksum;

import com.revature.beans.Person;

public class LoopyLoops {

	static int x = 5;
	static String color;
	static int[] myArray = {12, 13, 314, 123, 21, 423, 23, 2, 90, 293};
	static Person a = new Person("Leo", 23, 70);
	static Person c = new Person("Lea", 223, 0);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//whatColor("green");
		//forEachLoopFun("123123213123123213123");
		//doWhileyWhile(0);
		checkStuff(a, c);
		
		do {
		} while (false);

		// while(false) {}

		// if(false) {

		// }else {}

	}
	public static void checkStuff(int a, int b) {
		if(a==b) {
			System.out.println("same int");
		}else {System.out.println("not same int");}
	}
	public static void checkStuff(Person a, Person b) {
		if(a.equals(b)) {
			System.out.println("same");
		}else {System.out.println("not");}
	}
	

	public static void whatColor(String color) {

		switch (color) {
		case ("green"):
			System.out.println("1" + color);
			break;
		case ("orangered"):
			System.out.println("2" + color);
			break;
		case ("blue"):
			System.out.println("3" + color);
			break;
		default:
			System.out.println("4" + color);
			break;
		}
	}

	public static void forLoopFun(int x) {
		
		for (int i = 0; i < x; i++) {
			if(i % 2 != 0) {
				//break;
				continue;
			}
			System.out.println(i + " High " + x);
		}
	}
	
	
	public static void forEachLoopFun(String st) {
		for(char c : st.toCharArray()){
			System.out.println(c);
		}
	}
	
	public static void doWhileyWhile(int i) {
		do {
			System.out.println("KTHXBYE");
			
		}while(++i<10);
	}
}