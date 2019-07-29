package com.revature.beans;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Altered Admin class to utilize DB & SQL functionality. Obsolete, will be deleted once methods are copied over.
 * AUTHOR: redc
 * DATE: 28JUL2019
 */

public class Admin extends Employee {
	private int emplId;
	private String firstname;
	private String lastname;
	private String emailAddr;
	private String addr;
	private String cityName;
	private String stateName;
	private String uName;
	private String pw;
	private String type;

	public Admin() 
	{
		
	}
	
	public Admin(int id, String first, String last, String email, String address, String city,
			String state, String username, String password, String emplType) {
		emplId = id;
		firstname = first;
		lastname = last;
		emailAddr = email;
		addr = address;
		cityName = city;
		stateName = state;
		uName = username;
		pw = password;
		type = emplType;
	}
	
	

	/*
	 * Should be used to correct invalid transactions and for chargebacks.
	 */
	public void makeTransaction()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("What is the nature of the transaction? (withdraw/deposit)");
		String trans = in.next();
		System.out.println("What is the account number?");
		int id = in.nextInt();
		System.out.println("What is the amount of the transaction?");
		double val = in.nextDouble();
		
		System.out.println("Committing changes now.");
		Transaction t = new Transaction(id, val, trans);
		t.transType(t);
		in.close();
	}
	
	//Gives chance to reverse decision before removing acct from account list. Does not delete the account #'s text file however. Copy over in admin menu, then remove.
	public void deleteAcc(int accNum) 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Are you sure you would like to delete account #" + accNum + "? (y/n)");
		String ans = in.next();
		
		if(ans.equals("y"))
		{
			try {
				
				//Searches for account number in ArrayList, removes if found.
				ArrayList<Integer> accounts = getAccounts();
				for (int i = 0; i < accounts.size(); i++)
				{
					if (accounts.get(i) == accNum)
					{
						accounts.remove(i);
						break;
					}
				}
				
				//Rewrites file to reflect change.
				File file = new File("accountNos.txt");
				PrintWriter out = new PrintWriter(file);
				for (int i = 0; i < accounts.size(); i++)
				{
					out.print(accounts.get(i) + ",");
				}
				out.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Account has been deleted.");
		}
		
		else if(ans.equals("n"))
		{
			System.out.println("Understood. Account will not be removed.");
		}
		
		else
		{
			System.out.println("Invalid command. Please choose y or n to continue.");
		}
		
		in.close();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
