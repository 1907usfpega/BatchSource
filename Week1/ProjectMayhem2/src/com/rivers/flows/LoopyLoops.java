package com.rivers.flows;

public class LoopyLoops {

	public static void main(String[] args) {
		/*
		 * If statement for decision making provides multiple paths of execution
		 * 
		 * if(<condition>){ <what to do if true> } else{ <what to do if false> }
		 * 
		 * Switch Cases provides multiple paths of execution based on some value the
		 * "switch" is based on an integer numeric, a sting a char, a boolean, or enum
		 */
		//whatColor("weresaref");
		//forLoopFunness(30);
		//forEachFun(myArray);
		//wileyWhile(-35);
		Person a =new Person("Matt");
		Person b =new Person("Matt");
		checkStuff(a,b);
	

	}

	static String color;

	public static void whatColor(String color) {
		switch (color) {
		case "green":
			System.out.println("yo, the color is green, dog");
			break;
		case "orangered":
			System.out.println("what just happened");
			break;
		case "purple":
			System.out.println("purple is pretty kewl");
			break;
		case "puce":
			System.out.println("Dont take anymore suggestions from Jackson");
			break;
		default:
			System.out.println("YOU SUCK!");
			// order matters if there isnt a break
			break;

		}

	}

	/*
	 * For Loops for(a;b;c){do something} a is variable declaration (counter) b is
	 * the condition that controls how far the loop the loop will go c is the
	 * incrementor/decrementor
	 */

	public static void forLoopFunness(int p) {
		for (int i = p; i > 0; i--) {
			if(i==10) {
				//break and continue
				//break;
				break;
				
			}
				System.out.println(i);

		}
		/* enhanced for loop aka "for each"
		 * for (x:<Array or Collection>
		*/
		
		 int [] myArray= {11,33,22,55,333,55,222,562,64,63};
		 public static void forEachFun(int [] a) {
				for(int i:a) {
					System.out.println(i);
				}
		}
	}
		/* while loops
		 * while(<condition>){d<do something>}
		 * 
		 * do while
		 * do{<do thing>} while (<condition>);
		 */
		
		public static void wileyWhile(int i) {
			        while(i++<10) {
				                System.out.println("man this is so exciting...not really");
				//i++;
			}
			        {
		
		i++;
		}
			
		
	}
		public static void checkStuff(int a,int b) {
			if (a==b) {
				System.out.println("same");
			}else {
				System.out.println("not same");
			}
		}
		
		public static void checkStuff(Person s, Person t) {
			System.out.println(s);
			System.out.println(t);
			if (s==t) {
			System.out.println("same");
			}else {
			System.out.println("not same");
			}
			}
		}


