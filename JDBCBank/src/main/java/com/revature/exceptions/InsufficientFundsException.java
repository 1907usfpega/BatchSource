package com.revature.exceptions;

/*
 * To be thrown whenever an account has insufficient funds for a withdrawal.
 * TODO: Complete implementation of exception. Incorporate into CustomerMenu & AdminMenu classes.
 */

public class InsufficientFundsException extends RuntimeException {

	private static final long serialVersionUID = -7037629381926694037L;
	
	public InsufficientFundsException()
	{
		
	}
	
	public InsufficientFundsException(String errorMessage)
	{
		super(errorMessage);
	}
	
	public InsufficientFundsException(String errorMessage, Throwable cause)
	{
		super(errorMessage, cause);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
