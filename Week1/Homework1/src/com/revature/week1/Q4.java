package com.revature.week1;

public class Q4 
	{	
		public static int Task4(int n)
			{
				if(n==1) { return 1;}
				else {return n*Task4(n-1); }
			}
}
