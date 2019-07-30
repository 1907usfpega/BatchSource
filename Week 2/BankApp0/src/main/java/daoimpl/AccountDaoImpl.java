package daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
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

}
