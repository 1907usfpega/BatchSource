package daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.dao.UserDao;

import util.ConnFactory;

public class UserDaoImpl implements UserDao {
	
	public UserDaoImpl() {
		super();
	}

	public static ConnFactory cf = ConnFactory.getInstance();

	public void createUser(String un, String pw) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO BANKUSERS VALUES(USERSEQ.NEXTVAL,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, un);
		ps.setString(2, pw);
		ps.executeUpdate();
	}

	public boolean uniqueUserName(String un) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM BANKUSERS WHERE USER_NAME = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, un);	
		ResultSet rs = ps.executeQuery();
		if (!rs.next()) return true;
		return false;
	}

	public boolean correctPassword(String un, String pw) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT PASSWORD FROM BANKUSERS WHERE USER_NAME = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, un);
		ResultSet rs = ps.executeQuery();
		String qresult = "";
		if(rs.next()) {
			qresult = rs.getString(1);
		}
		if (qresult.equals(pw)) {
			return true;
		}
		return false;
	}
	
	public int getUID(String un) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT USER_ID FROM BANKUSERS WHERE USER_NAME = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, un);
		ResultSet rs = ps.executeQuery();
		int qresult = 0;
		if(rs.next()) {
			qresult = rs.getInt(1);
		}
		return qresult;
	}

	public void updatePassword(String un, String pw) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "UPDATE BANKUSERS SET PASSWORD = ? WHERE USER_NAME = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, pw);
		ps.setString(2, un);
		ps.executeUpdate();
	}

	public void delUser(String un) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call DELUSER(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, un);
		call.execute();
	}
	
	
	
}
