package Dao;

import java.sql.SQLException;
import java.util.List;

import methods.Account;

public interface UserDao {

	void createAccount(int userid, int loginid) throws SQLException;
	List<AccountDao> getAccount(int userid) throws SQLException;
	void deposit(int accountid,double balance) throws SQLException;
	void withdraw(int accountid, double balance)throws SQLException;
	void deleteAccount(int accountid) throws SQLException;
	Account checkAccount(int accountid, int userid) throws SQLException;
}

