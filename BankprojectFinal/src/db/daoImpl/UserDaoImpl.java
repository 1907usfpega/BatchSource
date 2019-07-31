package db.daoImpl;


import db.beans.User;
import db.beans.UserAccount;
import db.dao.*;
	import db.util.*;

	import java.sql.CallableStatement;
	import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;

	public class UserDaoImpl implements UserDao{
		public static ConnFactory cf = ConnFactory.getInstance();
		@Override
		public void registerUser(String username,String password ) throws SQLException {
			Connection conn = cf.getConnection();
			String sql = "INSERT INTO USER1 ( username,password )VALUES(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
		
			ps.setString(1, username);
			ps.setString(2, password);
			ps.executeUpdate(); 
		}
		
		public UserAccount Viewaccountbalance (String username) throws SQLException {
			Connection conn = cf.getConnection();
			// TODO Auto-generated method stub
		    String sql = "a.accountnum, a.balance from AccountUser a where a.userid=?\"";
		    PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
	            String accountnum = rs.getString("accountNum");
	            int balance = rs.getInt("balance");
	            UserAccount user = new UserAccount (accountnum,balance);
	            return user;
	        }
			return null;
		    
			 }
		
	    public void deposit(String  accountnum, int balance) throws SQLException {
	        Connection conn = cf.getConnection();
	        balance *= -1;
	        String sql = "{call updateaccount(?,?)";
	        CallableStatement call = conn.prepareCall(sql);
	        call.setString(1, accountnum);
	        call.setInt(2, balance);
	        call.execute();
	        System.out.println("Money depositted");
	    }

		@Override
		public void deleteUser(String username) throws SQLException {
			// TODO Auto-generated method stub
			Connection conn = cf.getConnection();
			// TODO Auto-generated method stub
			 String sql = "Delete From USER where userid= ?";
			 PreparedStatement ps = conn.prepareStatement(sql);
			   ps.setString(1, username);
			   ps.executeUpdate(); }

		@Override
		public void CreateUser(String accountnum,int balance ,String username) throws SQLException {
			// TODO Auto-generated method stub
			
			Connection conn = cf.getConnection();
			String sql = "INSERT INTO USERACCOUNT (accountnum,balance ,userid )VALUES(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
		
			ps.setString(1, accountnum);
			ps.setString(2, username);
			ps.setInt(3, balance);
			ps.executeUpdate(); 
		}
			
		}
			
		
	
		
		