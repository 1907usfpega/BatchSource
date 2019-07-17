package com.revature.flows;

public class LoopyLoops {

	public static void main(String []args) {
		/*whatColor("feufvbefsjen");
		forLoopFunness(66);*/
		//forEachFun(myArray);
		//wileyWhile(-34);
		doWhileyWhile(0);
	}
	static String color;
	public static void whatColor(String color) {
		switch(color) {
		case "green":
			System.out.println("yo, the color is green, dawg");
			break;
		case "orangered":
			System.out.println("what just happened");
			break;
		case "purple":
			System.out.println("purple is pretty kewl");
			break;
		case "puce":
			System.out.println("Don't take any more suggestions from Jackson");
			break;
		default:
			System.out.println("You suck!");
		}
	}
	public static void forLoopFunness(int p){
		for(int i = p; i > 0; i--) {
			if(i==10) continue;
			System.out.println(i);
		}
	}
	static int []myArray = {1,4,2,65,674532,425736886,95465,342};
	public static void forEachFun(int []a) {
		for(int i:a) {
			System.out.println(i);
		}
	}
	public static void wileyWhile(int i) {
		while(i < 10) {
			System.out.println("man this is so exciting.....not");
			i++;
		}
	}
	public static void doWhileyWhile(int i) {
		do {
			System.out.println("still boring" + i);
			i++;
		}while(i < 10);
	}
	public LoopyLoops() {
		
	}

}
