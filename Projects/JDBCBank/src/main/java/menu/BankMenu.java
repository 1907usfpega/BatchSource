package menu;

import java.util.Scanner;

import utilities.Helper;

public class BankMenu {
	Scanner sc = new Scanner(System.in);
	String select;
	Helper h = new Helper();
	public int userMenu() {
		System.out.println("Welcome to your Account Menu\n\n\n");
		System.out.println("Please select one of the following options");
		System.out.println("1. View your account balance");
		System.out.println("2. Make a bank transaction");
		System.out.println("3. Create a new account");
		System.out.println("4. Delete an existing account");
		System.out.println("5. Logout");
		do {
			select=sc.nextLine();
			if(h.isInteger(select) && Integer.parseInt(select)<=5 && Integer.parseInt(select) >=1) {
				return Integer.parseInt(select);
			}
			else {
				System.out.println("Invalid input, please pick a number that is shown");
			
			}
		}
		while (!h.isInteger(select) || Integer.parseInt(select)>5 || Integer.parseInt(select) <1);
		return -1;
		
	}
	
	public int adminMenu() {
		System.out.println("Welcome to Administrator access\n\n\n");
		System.out.println("Please select one of the following options");
		System.out.println("1. View an account balance");
		System.out.println("2. Make a bank transaction");
		System.out.println("3. Create a new account/user");
		System.out.println("4. Delete an existing account");
		System.out.println("5. Logout");
		do {
			select=sc.nextLine();
			if(h.isInteger(select) && Integer.parseInt(select)<=5 && Integer.parseInt(select) >=1) {
				return Integer.parseInt(select);
			}
			else {
				System.out.println("Invalid input, please pick a number that is shown");
			}
		}
		while (!h.isInteger(select) || Integer.parseInt(select)>5 || Integer.parseInt(select) <1);
		return -1;
		
	}
	
	public int transMenu() {
		System.out.println("\n\n\nWelcome to your Transactions Menu\n\n\n");
		System.out.println("Please select one of the following options");
		System.out.println("1. View your account balance");
		System.out.println("2. Make a deposit to your account");
		System.out.println("3. Make a withdraw from your account");
		System.out.println("4. Make a transfer to another account");
		do {
			select=sc.nextLine();
			if(h.isInteger(select) && Integer.parseInt(select)<=4 && Integer.parseInt(select) >=1) {
				return Integer.parseInt(select);
				}
			else {
				System.out.println("Invalid input, please pick a number that is shown");
			}
		}
		while(!h.isInteger(select) || Integer.parseInt(select) > 4 || Integer.parseInt(select) < 1);
		return 0;
	}
	
	public int adminTransMenu() {
		System.out.println("\n\n\nWelcome to your Admin Transactions Menu\n\n\n");
		System.out.println("Please select one of the following options");
		System.out.println("1. View account balances");
		System.out.println("2. Make a deposit to an account");
		System.out.println("3. Make a withdraw from an account");
		System.out.println("4. Make a transfer between accounts");
		do {
			select=sc.nextLine();
			if(h.isInteger(select) && Integer.parseInt(select)<=4 && Integer.parseInt(select) >=1) {
				return Integer.parseInt(select);
				}
			else {
				System.out.println("Invalid input, please pick a number that is shown");
			}
		}
		while(!h.isInteger(select) || Integer.parseInt(select) > 4 || Integer.parseInt(select) < 1);
		return 0;
	}

}
