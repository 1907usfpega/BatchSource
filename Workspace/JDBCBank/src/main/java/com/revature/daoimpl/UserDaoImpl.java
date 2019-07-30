package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.bean.Account;
import com.revature.bean.User;
import com.revature.dao.UserDao;
import com.revature.driver.Driver;
import com.revature.util.ConnFactory;

public class UserDaoImpl implements UserDao {
	public static ConnFactory cf = ConnFactory.getInstance();

	public void createUser(String username, String userpass) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call create_new_user(?,?)}";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, username);
		call.setString(2, userpass);
		call.execute();

	}

	public void deleteUser(int user_id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call delete_user(?)}";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, user_id);
		call.execute();
	}

	public void updateUser(int user_id, String username, String userpass) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call update_user(?,?,?)}";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, user_id);
		call.setString(2, username);
		call.setString(3, userpass);
		call.execute();
	}

	public void updateUserName(int user_id, String username) throws SQLException {
		String pass = null;
		for (User user : Driver.allUsers) {
			if (user.getUser_id() == user_id) {
				pass = user.getPassword();
			}
		}

		updateUser(user_id, username, pass);

	}
	
	public void updateUserPass(int user_id, String userpass) throws SQLException {
		String username = null;
		for (User user : Driver.allUsers) {
			if (user.getUser_id() == user_id) {
				username = user.getUsername();
			}
		}

		updateUser(user_id, username, userpass);

	}

	public ArrayList<User> getUserList() throws SQLException {
		ArrayList<User> userList = new ArrayList<User>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM USERS");
		User u = null;
		while (rs.next()) {
			u = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
			userList.add(u);
		}
		return userList;
	}
	
	public ArrayList<Account> getAccountList(int userid) throws SQLException {
		ArrayList<Account> accountList = new ArrayList<Account>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "SELECT * FROM ACCOUNT WHERE user_id=" + userid;
		ResultSet rs = stmt.executeQuery(sql);
		Account ac = null;
		while (rs.next()) {
			ac = new Account(rs.getInt(1), rs.getDouble(2), rs.getInt(3));
			accountList.add(ac);
		}
		return accountList;
	}

}
