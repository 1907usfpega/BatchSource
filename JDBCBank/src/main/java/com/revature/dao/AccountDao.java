package com.revature.dao;

public interface AccountDao {
	void createAccount(String n, String t, int i);
	void updateAccounts(int a, int b);
	void deleteAccount(int a);
}
