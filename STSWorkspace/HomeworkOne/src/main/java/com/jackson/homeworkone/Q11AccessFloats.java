package com.jackson.homeworkone;

import com.jackson.question11.Q11FloatsOrigin;

public class Q11AccessFloats 
{
	public int addTheseNums()
	{
		Q11FloatsOrigin q11 = new Q11FloatsOrigin();
		System.out.print("Float X: "+q11.x+" + Float Y: "+q11.y+" = ");
		return q11.x + q11.y;
	}
}
