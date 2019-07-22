/**
 * 
 */
package com.revature.core;

import com.revature.core.helper.IOperands;

/**
 * @author MajorKey
 *Question 15
 */
public class Operands implements IOperands {

	@Override
	public int addition(int a, int b) {
		return a + b;
	}

	@Override
	public int subtraction(int a, int b) {
		// TODO Auto-generated method stub
		return a - b;
	}

	@Override
	public int multiplication(int a, int b) {
		// TODO Auto-generated method stub
		return a * b;
	}

	@Override
	public int division(int a, int b) {
		// TODO Auto-generated method stub
		return a / b;
	}

	public static void main(String [] args) {
		//create operand obj
		//implement some methods from operand and print out
		//print some hard coded operations to compare
		
		Operands op = new Operands();
		int a,b;
		a = 5;
		b = 3;
		System.out.print(op.addition(a, b) + " = ");
		System.out.println(a+ " + " + b + " = " + (a+b));
		System.out.print(op.subtraction(a, b)+ " = ");
		System.out.println(a+ " - " + b + " = " + (a-b));
		System.out.print(op.multiplication(a, b) + " = ");
		System.out.println(a+ " * " + b + " = " + (a*b));
		System.out.print(op.division(a, b)+ " = ");
		System.out.println(a+ " / " + b + " = " + (a/b));
	}
}

/*class main {
	public static void main(String [] args) {
		//create operand obj
		//implement some methods from operand and print out
		//print some hard coded operations to compare
		
		Operands op = new Operands();
		int a,b;
		a = 5;
		b = 3;
		System.out.print(op.addition(a, b) + " = ");
		System.out.println(a+ " + " + b + " = " + (a+b));
		System.out.print(op.subtraction(a, b)+ " = ");
		System.out.println(a+ " - " + b + " = " + (a-b));
		System.out.print(op.multiplication(a, b) + " = ");
		System.out.println(a+ " * " + b + " = " + (a*b));
		System.out.print(op.division(a, b)+ " = ");
		System.out.println(a+ " / " + b + " = " + (a/b));
	}
}
*/