package com.jackson.homeworkone;

import com.jackson.question11.Q11FloatsOrigin;

public class Q11AccessFloats 
{
	public int addTheseNums()
	{
		//create the class from another package
		Q11FloatsOrigin q11 = new Q11FloatsOrigin();
		//print out the original float values
		System.out.print("Float X: "+q11.x+" + Float Y: "+q11.y+" = ");
		//return the sum of the floats
		return q11.x + q11.y;
	}
}
