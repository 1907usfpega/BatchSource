package daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.dao.AccountDao;

import util.ConnFactory;

public class AccountDaoImpl implements AccountDao {

	public AccountDaoImpl() {
		super();
	}
	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void createAccount(String nickname, int uid) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call MAKEACCT(?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, nickname);
		call.setInt(2, uid);
		call.execute();
	}

	public void deleteAccount(String nickname, int uid) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call DELACCT(?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, nickname);
		call.setInt(2, uid);
		call.execute();
	}

	public void deposit(String nickname, double depositAmt, int uid) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call DEPOSIT(?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, nickname);
		call.setDouble(2, depositAmt);
		call.setInt(3, uid);
		call.execute();
	}

	public void withdraw(String nickname, double withdrawAmt, int uid) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call WITHDRAW(?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, nickname);
		call.setDouble(2, withdrawAmt);
		call.setInt(3, uid);
		call.execute();
	}
	
	public void getAllAccounts(int UID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM ACCOUNT WHERE USER_ID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, UID);
		ResultSet rs = ps.executeQuery();
		int column = 1;
		while(rs.next()) {
			System.out.println("Account ID: " + rs.getString(column++));
			column++;
			System.out.println("Account Name: " + rs.getString(column++));
			System.out.println("Balance: " + rs.getDouble(column) + "\n");
			column = 1;
		}
	}

	public double getBalance(int UID, String nickname) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT BALANCE FROM ACCOUNT WHERE USER_ID = ? AND ACCOUNT_NICKNAME = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, UID);
		ps.setString(2, nickname);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) return rs.getDouble(1);
		return -1.0;
	}

	public boolean accountExists(int UID, String nickname) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM ACCOUNT WHERE USER_ID = ? AND ACCOUNT_NICKNAME = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, UID);
		ps.setString(2, nickname);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) return true;
		return false;
	}
	
}
