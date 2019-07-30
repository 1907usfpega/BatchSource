package com.revature.methods;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.pojo.BankAccount;
import com.revature.pojo.User;

public interface AccountMethods {
		
		
		public List<BankAccount> viewAccount(User u);
		public int createAccount(User u,int accountID);
		public boolean deleteAccount(int accountID);
		public boolean changeValue(int accountID, double value) throws SQLException, IOException;

		
		public int TransactionHistory(int accountID);
		
		
}

