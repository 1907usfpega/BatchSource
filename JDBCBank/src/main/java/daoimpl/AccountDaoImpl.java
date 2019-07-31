package daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.AccountDao;
import util.ConnectionFactory;

public class AccountDaoImpl implements AccountDao{

	public static ConnectionFactory cf = ConnectionFactory.getInstance();

	
	//--------------------------------------Create Account-----------------------------------------------------
	public void createAccount(int customerID, String accountType, double balance) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call insert_accounts(?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, customerID);
		call.setString(2, accountType);
		call.setDouble(3, balance);
		call.execute();
	}//end createAccount()
	
	
	//--------------------------------------Get Account-----------------------------------------------------
	public boolean getAccount(int customerID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM accounts WHERE fk_customer_id = ?";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, customerID);
		ResultSet rs = call.executeQuery();
		if (rs.next()) {
			return true;
		}
		else{
			return false;
		}
	}//end getAccount()

	
	//--------------------------------------List Accounts-----------------------------------------------------
		public void listAccounts(int customerID) throws SQLException {
			Connection conn = cf.getConnection();
			String sql = "SELECT * FROM accounts WHERE fk_customer_id = ?";
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1, customerID);
			ResultSet rs = call.executeQuery();
			int column = 1;
			while(rs.next()) {
				System.out.println("Account_ID: " + rs.getInt(column++));  //<--Cycles through and lists all accounts
				column++;
				System.out.println("Account Type: " + rs.getString(column++));
				System.out.println("Balance: $" + rs.getDouble(column) + "\n");
				column = 1;
			}
		}//end listAccounts()

	//--------------------------------------Get Account Balance-----------------------------------------------------
	public double getBalance(int accountID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT balance FROM accounts WHERE account_id = ?";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, accountID);
		ResultSet rs = call.executeQuery();
		rs.next();
		return rs.getDouble(1);
	}//end getBalance()
	
	
	//--------------------------------------Update Balance-----------------------------------------------------
	public void updateBalance(double balance, int accountID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call update_account_balance(?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setDouble(1, balance);
		call.setInt(2, accountID);
		call.execute();
	}//end updateBalance
	
	
	//--------------------------------------Verify AccountID-----------------------------------------------------
	public boolean verifyAccountID(int customerID, int accountID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT account_id FROM accounts WHERE fk_customer_id = ?";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, customerID);
		ResultSet rs = call.executeQuery();
		int testAccount = 0;
		while (rs.next()) {
			testAccount = rs.getInt(1);
			if(testAccount == accountID) {
				return true;
			}
		}
		return false;
	}//end verifyAccountID()
	
	
	//--------------------------------------Delete Account-----------------------------------------------------
	public void deleteAccount(int accountID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "DELETE FROM accounts WHERE account_id = ?";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, accountID);
		call.execute();
	}//end deleteAccount()


}//end AccountDaoImpl class
