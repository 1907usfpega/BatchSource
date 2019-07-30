package com.revature.methods;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.BankAccount;
import com.revature.pojo.User;
import com.revature.sql.ConnectionUtil;

public class BankMethods implements AccountMethods {
		
		public boolean changeValue(int accountID, double value) throws SQLException, IOException {
			String stmt = "SELECT * FROM ACCOUNTS WHERE ACCOUNT_ID = ?";
			
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(stmt);
			pstmt.setInt(1, accountID);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next() == false) {
				return false;
			}
			else {
				int colBal = rs.findColumn("ACCOUNT_BALANCE");
				double balance = rs.getDouble(colBal);
				double result = balance + value;
				if(result < 0) {
					return false;
				}
				else {
					String stmt2 = "UPDATE ACCOUNTS SET ACCOUNT_BALANCE = ? WHERE ACCOUNT_ID = ?";
					Connection connection2 = ConnectionUtil.getConnection();
					PreparedStatement pstmt2 = connection2.prepareStatement(stmt2);
					pstmt2.setDouble(1,result);
					pstmt2.setInt(2,accountID);
					ResultSet rs2 = pstmt2.executeQuery();
					rs2.close();
					connection2.close();
				}
				return true;
				
			}
		}

		public List<BankAccount> viewAccount(User u) {
			String stmt = "SELECT * FROM BANK_USERS WHERE BANK_USERS.USER_NAME = ? AND BANK_USERS.USER_PASSWORD = ?";

			try {
				Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(stmt);
				pstmt.setString(1, u.getUsername());
				pstmt.setString(2, u.getPassword());
				ResultSet rs = pstmt.executeQuery();
				if (rs.next() == false) {
					return null;
				}
				else {
					int id = rs.getInt(1);
					
					String baStmt = "SELECT * FROM ACCOUNTS WHERE USER_ID = ?";
					connection.close();
					connection = ConnectionUtil.getConnection();
					PreparedStatement pstmt2 = connection.prepareStatement(baStmt);
					pstmt2.setInt(1, id);
					ResultSet rs2 = pstmt2.executeQuery();
					
					if(rs2.next() == false) {
						System.out.println("No Accounts");
						return null;
						
					}
					
					ArrayList<BankAccount> blist = new ArrayList<BankAccount>();
					do {
						int colAccID = rs2.findColumn("ACCOUNT_ID");
						int colBal = rs2.findColumn("ACCOUNT_BALANCE");
						BankAccount ba = new BankAccount(rs2.getInt(colAccID), rs2.getDouble(colBal), id);
						blist.add(ba);
					} while(rs2.next());
					
					
					rs.close();
					connection.close();
					
					rs2.close();
					connection.close();
					
					return blist;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

			// TODO Auto-generated method stub
			return null;
		}

		public int createAccount(User u, int accountID) {
			// TODO Auto-generated method stub
			int uid = u.getUserID();
			String stmt = "INSERT INTO ACCOUNTS(ACCOUNT_BALANCE,USER_ID) VALUES (0,?)";
			Connection connection;
			try {
				connection = ConnectionUtil.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(stmt);
				pstmt.setInt(1,uid);
				ResultSet rs = pstmt.executeQuery();
				connection.close();
				return 1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}

		public boolean deleteAccount(int accountID) {
			// TODO Auto-generated method stub
			String stmt = "DELETE FROM ACCOUNTS WHERE ACCOUNT_ID = ?";
			Connection connection;
			try {
				connection = ConnectionUtil.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(stmt);
				pstmt.setInt(1,accountID);
				ResultSet rs = pstmt.executeQuery();
				rs.close();
				connection.close();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}

		public int TransactionHistory(int accountID) {
			// TODO Auto-generated method stub
			return 0;
		}
		
}
	



