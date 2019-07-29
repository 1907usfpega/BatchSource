/**
 * 
 */
package daoimpl;

import java.sql.Connection;
import java.sql.SQLException;
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

	}

	public List<Account> getAccounts(int userid) throws SQLException {
		Connection conn = cf.getConnection();
		return null;
	}

	public void deposit(int accountid, double balance) throws SQLException {
		Connection conn = cf.getConnection();

	}

	public void withdraw(int accountid, double balance) throws SQLException {
		Connection conn = cf.getConnection();

	}

	public void deleteAccount(int accountid) throws SQLException {
		Connection conn = cf.getConnection();

	}

}
