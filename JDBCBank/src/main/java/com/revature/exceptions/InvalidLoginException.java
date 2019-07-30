package com.revature.exceptions;

/*
 * InvalidLoginException should be thrown when username/password credentials do not match. Still working out the kinks. :D
 * 
 * AUTHOR: redc
 */

public class InvalidLoginException extends RuntimeException {

	private static final long serialVersionUID = 8675309;
	
	public InvalidLoginException(String errorMessage)
	{
		super(errorMessage);
		System.out.println("Invalid login. Please try again.");
	}
	
	public InvalidLoginException(String errorMessage, Throwable cause)
	{
		super(errorMessage, cause);
	}
	
	public InvalidLoginException() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
