package com.revature.bank;

public class Account {

	private int accountNumber = 333000;
	private double balance = 250;
	private Boolean isApproved = false, appliedForJointAccount = false;

	public void withdraw(double amount) {
		if (amount >= 0) {
			if (this.balance - amount >= 0) {
				this.balance = this.balance - amount;
				System.out.println("New Balance is: $" + this.balance);
			} else {
				System.out.println("Not enough funds.  You tried to Withdraw $" + amount + ", Current balance is: $"
						+ this.balance);
			}
		} else {
			System.out.println("you tried to withdraw a negative amount.  Please try again!");
		}
	}

	public void deposit(double amount) {
		if (amount >= 0) {
			if (this.balance - amount >= 0) {
				this.balance = this.balance + amount;
				System.out.println("New Balance is: $" + this.balance);
			} else {
				System.out.println("Invalid Deposit, You cannot deposit a negative amount.  You tried to Withdraw $"
						+ amount + ", Current balance is: $" + this.balance);
			}
		} else {
			System.out.println("You Deposited $0.00, No changes have been made to your balance!");
		}
	}

	public void transfer(double amount, Account transfer) {
		if (amount >= 0) {
			if (this.balance - amount >= 0) {
				System.out.println("Witdrawing from account " + getAccountNumber());
				withdraw(amount);
				System.out.println("Transferring Funds To Account " + transfer.getAccountNumber());
				transfer.deposit(amount);
			} else {
				System.out.println("Not enough funds.  You tried to Transfer $" + amount + ", Current balance is: $"
						+ this.balance);
			}
		} else {
			System.out.println("you tried to transfer a negative amount.  Please try again!");
		}
	}

	public double getBalance() {
		return balance;
	}

	public Boolean getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(boolean decision) {

		isApproved = decision;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountEndingNumber) {
		accountNumber = accountNumber + accountEndingNumber;
	}

	public Boolean getAppliedForJointAccount() {
		return appliedForJointAccount;
	}

	public void setAppliedForJointAccount(Boolean appliedForJointAccount) {
		this.appliedForJointAccount = appliedForJointAccount;
	}
}
