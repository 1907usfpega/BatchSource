package com.revature.dao;

import java.util.ArrayList;


public interface AnUDao {
	
	public abstract void linkUserAndAccount(int uId, int aId);
	
	public abstract void unlinkAllUsersAccounts(int uId);
	
	public void unlinkAllAccountUsers(int aId);
	
	public abstract void unlinkUserAndAccount(int uId, int aId);

	public abstract ArrayList<Integer> allAccounts(int uId);
	
	public abstract ArrayList<Integer> allUsers(int aId);
	
	public abstract int currentAccountSEQ();
}
