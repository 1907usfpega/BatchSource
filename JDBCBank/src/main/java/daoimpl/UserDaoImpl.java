package daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UserDao;
import util.ConnectionFactory;

public class UserDaoImpl implements UserDao{

	public static ConnectionFactory cf = ConnectionFactory.getInstance();

	//--------------------------------------Checks Username-----------------------------------------------------
	public boolean checkUsername(String username) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT username FROM bank_user WHERE username = ?";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, username);	
		ResultSet rs = call.executeQuery();
		if (rs.next()) {
			return false;
		}
		else{
			return true;
		}
	}//end checkUserName()


	//--------------------------------------Checks Password-----------------------------------------------------
	public boolean checkPassword(String username, String password) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT user_password FROM bank_user WHERE username = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);	
		ResultSet rs = ps.executeQuery();
		String testPassword = "";
		if (rs.next()) {
			testPassword = rs.getString(1);
			if(testPassword.equals(password)) {
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}//end checkUserPassword()


	//--------------------------------------Creates User-----------------------------------------------------
	public void createUser(String username, String password, String userType) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call insert_bank_user(?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, username);
		call.setString(2, password);
		call.setString(3, userType);
		call.execute();
	}//end createUser()


	//--------------------------------------Gets UserID-----------------------------------------------------
	public int getID(String username) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT user_id FROM bank_user WHERE username = ?";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, username);
		ResultSet rs = call.executeQuery();
		int testID = 0;
		if(rs.next()) {
			testID = rs.getInt(1);
		}
		return testID;
	}//end getID()


	//--------------------------------------Gets UserType-----------------------------------------------------
	public String getType(String username) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT user_type FROM bank_user WHERE username = ?";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, username);
		ResultSet rs = call.executeQuery();
		String type = "";
		if(rs.next()) {
			type = rs.getString(1);
		}
		return type;
	}//end getType()

	
	//--------------------------------------List Users-----------------------------------------------------
	public void listUsers() throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM bank_user LEFT JOIN customer ON user_id = fk_user_id LEFT JOIN accounts ON customer_id = fk_customer_id";
		CallableStatement call = conn.prepareCall(sql);
		ResultSet rs = call.executeQuery();
		int column = 1;
		while(rs.next()) {
			System.out.print("User ID: " + rs.getInt(column++));  //<--Cycles through and lists all accounts
			System.out.print("  Username: " + rs.getString(column++));
			System.out.print("  Password: " + rs.getString(column++));
			System.out.println("  User Type: " + rs.getString(column++));
			System.out.print("  Customer ID: " + rs.getInt(column++));
			column++;
			System.out.println("  Customer Name: " + rs.getString(column++));
			System.out.print("  Account ID: " + rs.getInt(column++));
			column++;
			System.out.print("  Account Type: " + rs.getString(column++));
			System.out.print("  Balance: " + rs.getDouble(column++));
			System.out.println("\n");
			column = 1;
		}
	}//end listAccounts()
	
	
	//--------------------------------------Delete User-----------------------------------------------------
	public void deleteUser(int userID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "DELETE FROM bank_user WHERE user_id = ?";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, userID);
		call.execute();
	}//end deleteAccount()

}//end UserDaoImpl class
