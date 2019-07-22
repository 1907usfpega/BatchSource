package com.revature.args;

class simple{
	public int simpleMethod(int a, int b){
		return a+b;
	}
	/*static void vaTest(int a) {
		System.out.println("only one int!");
	}*/
	static void vaTest(double a) {
		System.out.println("only one int!");
	}
	static void vaTest(Integer a) {
		System.out.println("only one int!");
	}
	static void vaTest(int ... v) {
		System.out.println("num of args is "+ v.length + "\n" + "contents:");
		for (int x: v) {
			System.out.print(x+" ");
		}
		System.out.println("");
	}
	//only 1 vararg per method, must be last param
	static void vaTest(String a, boolean b, int ... v) {
		System.out.println(a);
		System.out.println(!b);
		vaTest(v);
	}
}



public class Overriding extends simple {

	public static void main(String[] args) {
		Overriding a=new Overriding();
		Integer b = a.simpleMethod(6, 4);
		System.out.println(b);
		int d = 10;
		double c = 4.8;
		vaTest(d);
		vaTest(b);
		vaTest(c);
		vaTest(2,4,6);
		vaTest("HEWWO?",true,420,69);
		
	}
	
	@Override
	public int simpleMethod(int a,int b) {
		return a*b;
	}

}
