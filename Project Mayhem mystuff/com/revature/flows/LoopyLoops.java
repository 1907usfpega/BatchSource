package com.revature.flows;

public class LoopyLoops {

	public static void main(String[] args) {
		/*If statement
		 * For decision making
		 * provides mutiple paths of execution
		 * 
		 * if(<conditional>){
		 * <what to do if true>
		 * }
		 * else if (<second condition){
		 * <what to do if 2nd conditional is true>
		 * else{
		 * <what to do if flase>
		 * }
		 * 
		 * Switch cases
		 * provides multiple paths of execution based on some vlaue the "switch" is based on an integer numeric, a string
		 * a char, a boolean, or enum.
		 */
		
		//after it's created last step backwards, lets go call that thing, below is how you do it 
		//whatcolor ("shfkfsdj"); undo this comment to execute
		//forLoopFunness(66);
		//forEachFun(myArray);
		//wileyWhile(-34);
		doWhileyWhile(0);
		checkStuff(3,3);
		checkStuff(4,2);
		//make some people to do checkstuff
		

	}
	//entering ouside of main method
	static String color;
	//color= "green"; undo this 
	public static void whatColor(String color) {
		// what to do when are color equals
		switch(color) {
		case "green":
			System.out.println("yo, the color is green, dog");
		break;
		case "orangered":
			System.out.println("what just happned");
			break;
		case "purple":
			System.out.println("purple is pretty kewl");
		break;
		case "puce":
			System.out.println("Dont taky any more suggestions from Jackson");
			default:
			System.out.println("you suck!");
		}
	
	}
	/*For Loops
	 * for(a;b;c;){do something}
	 * a is variabke declaration (counter)
	 * b is the cindition that controls how far the loop will go 
	 * c is the incrementor/decrementor
	 */
	public static void forLoopFunness(int p) {
		for(int i=p;i>0; i--) {
			System.out.println(i);
			//== checks
			// sets equal to
			if(i==10) {
				//break and contiunue
				break; //mute to do the continue
				//continue; undo to interchange 
			
			System.out.println(i);
			//we set the condition
		}
	}
		/*Enhanced for loo aka "for each"
		 * for (x:<Array
		 */
		static int [] myArray= {11,3,4,5,34,23,56,33,367,54)}; //set array up withintegers
		public static void forEachFun(int  [] a) {
			for (int i:a) {
				System.out.println(i);
			}
		}
		/*While loops-check then do it if its true
		 * while(<conditoin>){<do something>}
		 * 
		 * do while- do it first 
		 * do {do thing} while (<condition>);
		 * 
		 */
		public static void wileyWhile (int i) {
			while(i++<10) {
				System.out.println("man thi is so exciting...not");
				//i++;
			}
		}
		//lets create a new method
		public static void doWileyWhile (int i) {
			do {System.out.println("still boring" +i);
			i++;
			}
			while(i<10);
		}
		}
	/*Conditionals
	 * 
	 */
	public static void checkStuff(int a,int b) {
		if (a==b) {
			System.out.println("same");
		}else {
			System.out.println("not same");
		}
	}
	public static checkStuff(Person s, Person t) {// overloading it
		if (s==t) {
			
		}
	}
}
