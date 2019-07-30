package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.bean.Account;
import com.revature.bean.User;
import com.revature.dao.AccountDao;
import com.revature.util.ConnFactory;

public class AccountDaoImpl implements AccountDao {
	public static ConnFactory cf= ConnFactory.getInstance();

	public void createAccount(int user_id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call create_new_account(?)}";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, user_id);
		call.execute();
		
	}

	public void deleteAccount(int account_id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call delete_account(?)}";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, account_id);
		call.execute();
		
	}

	public void updateBalance(int account_id, double balance) throws SQLException {
		
		Connection conn = cf.getConnection();
		String sql = "{call update_balance(?,?)}";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1,account_id);
		call.setDouble(2, balance);
		call.execute();
		
		
	}
	
	public List<Account> geAccountList() throws SQLException{
		List<Account>accountList = new ArrayList<Account>();
		Connection conn= cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNT");
		Account a = null;
		while(rs.next()) {
			a=new Account(rs.getInt(1), rs.getDouble(2), rs.getInt(3));
			accountList.add(a);
		}
			return accountList;
		}
	

}
