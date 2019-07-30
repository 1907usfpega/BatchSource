/**
 * 
 */
package daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import dao.ILoginDao;
import login.Login;
import util.ConnFactory;

/**
 * @author MajorKey
 *
 */
public class LoginDaoImpl implements ILoginDao {

	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void createLogin(String username, String password, int userid) throws SQLException {
		Connection conn = cf.getConnection();
		//String outputsql = "begin dbms_output.enable(); end;";
		String sql = "{call insertlogin(?,?,?,?)";
		//PreparedStatement ps = conn.prepareStatement(outputsql);
		//ps.executeUpdate();
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, username);
		call.setString(2, password);
		call.setInt(3, userid);
		call.setNull(4, Types.INTEGER);
		call.execute();
		//outputsql.replace("enable", "disable");
		//ps = conn.prepareStatement(outputsql);
		//ps.executeUpdate();
		System.out.println("Login Registered");
	}
	
	public Login checkLogin(String username, String password) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "Select loginid,adminid,userid FROM login WHERE (username = ? AND password = ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		Login login = null;
		
		while(rs.next()) {
			login = new Login(rs.getInt(1), rs.getInt(2), rs.getInt(3));
		}
		
		return login;
	}
	
	public int getLoginId(int userid) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT loginid FROM login WHERE userid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, userid);
		ResultSet rs = ps.executeQuery();
		int loginid = 0;
		while(rs.next()) {
			loginid = rs.getInt(1);
		}
		
		return loginid;
	}
	
	public boolean usernameAvailable(String username) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "Select loginid FROM login WHERE username = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			return false;
		}
		//return true if the username is available
		return true;
	}
}
