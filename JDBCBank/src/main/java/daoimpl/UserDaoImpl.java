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
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
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
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		String type = "";
		if(rs.next()) {
			type = rs.getString(1);
		}
		return type;
		
	}//end getType()
	
}//end UserDaoImpl class
