package DaoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.sql.ConnFactory;

import Dao.AccountDao;
import Dao.UserDao;
import methods.Account;
import methods.User;

public class DaoImplUser implements UserDao {

	public static ConnFactory cf = ConnFactory.getInstance();
	
	//creates a user
	public void createUser(String firstname, String lastname) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call insertuser(?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, firstname);
		call.setString(2, lastname);
		call.execute();
		System.out.println("User Created");
	}

	//returns the most recently created user
	public User getCurrentUser() throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "Select * FROM bankuser WHERE userid = (SELECT MAX(userid) FROM bankuser)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		User user = null;
		
		while(rs.next()) {
			user = new User(rs.getInt(1),rs.getString(2),rs.getString(3));
		}
		
		return user;
	}

	//returns a specified user by its id
	public User getUser(int id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "Select * FROM bankuser WHERE userid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		User user = null;
		
		while(rs.next()) {
			user= new User(rs.getInt(1), rs.getString(2), rs.getString(3));
		}
		
		return user;
	}

	//returns a list of every user in db
	public List<User> getAllUsers() throws SQLException {
		List<User> userList = new ArrayList<User>();
		Connection conn = cf.getConnection();
		
		String sql = "SELECT * FROM bankuser";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		User user = null;
		
		while (rs.next()) {
			user= new User(rs.getInt(1), rs.getString(2), rs.getString(3));
			userList.add(user);
		}
		return userList;
	}

	//has the procedure update the name of a specified user
	public void updateUser(int id, String firstname, String lastname) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call updateuser(?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		
		call.setInt(1, id);
		call.setString(2, firstname);
		call.setString(3, lastname);
		call.execute();

		System.out.println("User Updated");
	}

	//deletes a specified user from db
	public void deleteUser(int id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call deleteuser(?)";
		CallableStatement call = conn.prepareCall(sql);
		
		call.setInt(1, id);
		call.execute();
		
		System.out.println("User Deleted");
	}

	@Override
	public void createAccount(int userid, int loginid) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AccountDao> getAccount(int userid) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deposit(int accountid, double balance) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdraw(int accountid, double balance) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAccount(int accountid) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account checkAccount(int accountid, int userid) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}