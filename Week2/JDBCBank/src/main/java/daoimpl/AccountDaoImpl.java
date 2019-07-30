/**
 * 
 */
package daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import account.Account;
import dao.IAccountDao;
import util.ConnFactory;

/**
 * @author MajorKey
 *
 */
public class AccountDaoImpl implements IAccountDao {
	
	public static ConnFactory cf = ConnFactory.getInstance();

	public void createAccount(int userid, int loginid) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call insertaccount(?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, loginid);
		call.setInt(2, userid);
		call.execute();
		System.out.println("Account Created");
	}

	public List<Account> getAccounts(int userid) throws SQLException {
		List<Account> accountList = new ArrayList<Account>();
		Connection conn = cf.getConnection();
		
		String sql = "SELECT * FROM account WHERE userid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, userid);
		ResultSet rs = ps.executeQuery();
		Account account = null;
		
		while (rs.next()) {
			account= new Account(rs.getInt(1), rs.getDouble(2), rs.getInt(3), rs.getInt(4));
			accountList.add(account);
		}
		return accountList;
	}

	public void deposit(int accountid, double balance) throws SQLException {
		Connection conn = cf.getConnection();
		balance *= -1;
		String sql = "{call updateaccount(?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, accountid);
		call.setDouble(2, balance);
		call.execute();
		System.out.println("Money depositted");

	}

	public void withdraw(int accountid, double balance) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call updateaccount(?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, accountid);
		call.setDouble(2, balance);
		call.execute();
		System.out.println("Money Withdrawn");
	}

	public void deleteAccount(int accountid) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call deleteaccount(?)";
		CallableStatement call = conn.prepareCall(sql);
		
		call.setInt(1, accountid);
		call.execute();
		System.out.println("Account Deleted");
	}

	public Account checkAccount(int accountid, int userid) throws SQLException {
		Account account = null;
		Connection conn = cf.getConnection();
		
		String sql = "SELECT * FROM account WHERE (accountid = ? AND userid = ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, accountid);
		ps.setInt(2, userid);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			account= new Account(rs.getInt(1), rs.getDouble(2), rs.getInt(3), rs.getInt(4));
		}
		return account;
	}
}
