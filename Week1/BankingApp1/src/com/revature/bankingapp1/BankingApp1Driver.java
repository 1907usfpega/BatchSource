package com.revature.bankingapp1;


public class BankingApp1Driver {

	public BankingApp1Driver() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String args[]) {
		AccountsDatabase acctDB = 
				new AccountsDatabase("123456789", "Checking", "LeviApplebaum");
		acctDB.addAccount("987654321", "Savings", "EddieHeredia");
		acctDB.getAccount("987654321").approve();
		acctDB.getAccount("123456789").updateBalance(3.75);
		acctDB.printDatabase();
		acctDB.addUser("987654321", "BradleyCampbell");
		acctDB.printDatabase();
		acctDB.addUser("123456789", "JustinHua");
		acctDB.printDatabase();
		acctDB.removeUser("987654321", "BradleyCampbell");
		acctDB.printDatabase();
		acctDB.getAccount("123456789").printAccount();
		System.out.println(acctDB.getBalance("987654321"));
		System.out.println(acctDB.getUsers("123456789"));
	}
}
