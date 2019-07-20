/* ORDER OF EXECUTION
1)all STATIC Blocks
2)MAIN
3)CLASS Extends
4)Block Codes
5)Constructors
		  
ANSWER
		 	b3
			r1
			r4
			init
			b1
			b2
			r3
			r2
			hawk
*/

package com.revature.constructors;

public class Hawk extends Raptor {

	public Hawk() {	}

	public static void main(String[] args) {
		System.out.println("init");
		new Hawk();
		System.out.println("hawk");	
	}
}

class Raptor extends Bird{
	
	static { System.out.println("r1");} 
	
	public Raptor() {System.out.println("r2");}
	
	{ System.out.println("r3"); }
	
	static { System.out.println("r4");}
}

class Bird{
	
	{ System.out.println("b1"); }
	
	Bird(){ System.out.println("b2");}
	
	static { System.out.println("b3");}
}
