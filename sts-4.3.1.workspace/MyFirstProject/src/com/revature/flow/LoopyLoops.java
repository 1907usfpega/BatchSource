package com.revature.flow;

public class LoopyLoops {

	public static void main(String[] args) {
		//whatColor("purple");
		
		//forLoopCountdown(15);
		
		//forEachFun(myArray);
		
		//wileywhile(15);
		
		doWileywhile(15);

	}
	
	/*FOREACH
	 * Bad for removing itens*/
	static int [] myArray= {1,2,3,4,5,6,7,8,9};
	public static void forEachFun(int[] a) {
		for(int i:a) {
			System.out.println(i);
		}
		
	}
	/* SWITCH CASES
	 * multiple paths of execution based on an integer numeric, string,
	 * char, boolean or enum
	 */
	
	static String color;
	public static void whatColor(String color) {
		switch(color) {
		case "green": System.out.println("green");break;
		case "orange": System.out.println("orange");break;
		case "purple": System.out.println("purple");break;
		default: System.out.println("oh no!");// break;
		}
	}
	
	public static void forLoopCountdown(int p) {
		for (int i = p; i>0; i--) {
			if(i==10) {
				break;    //stops on #10
				//continue; skips #10
			}
			System.out.println(i);
		}
	}
	
	/*while(<condition>){<do something>}
	 * 
	 * do{<do thing>} while(<condition>)
	 */
	public static void wileywhile(int i) {
		while(i-->10) {
			System.out.println(i);
			//i++;
		}
	}
	public static void doWileywhile(int i) {
		do{System.out.println(i);
		i++;}
		while(i<10) ;
		}
	}


/* == or EQUALs
 * 
 * .equals() : looks ah the content. For objects
 */
