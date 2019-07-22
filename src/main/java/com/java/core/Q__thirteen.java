package com.java.core;
/*
 * Q13. Display the triangle on the console as follows using any type of loop.  
 * Do NOT use a simple group of print statements to accomplish this.  
 *	0 
 *	1 0
 *	1 0 1
 *	0 1 0 1
 * 
 * */
public class Q__thirteen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1; i<=4; i++){
			  for(int j=1; j<=i; j++){
			  if(j%2==1){
			      System.out.print("1");
			  }
			  else{
			      System.out.print("0");
			  }
			  
			}
			System.out.println();
			}
}
		
	}


