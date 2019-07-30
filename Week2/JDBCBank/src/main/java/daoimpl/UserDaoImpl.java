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

import dao.IUserDao;
import user.User;
import util.ConnFactory;

/**
 * @author MajorKey
 *
 */
public class UserDaoImpl implements IUserDao {

	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void createUser(String firstname, String lastname) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call insertuser(?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, firstname);
		call.setString(2, lastname);
		call.execute();
		System.out.println("User Created");
	}

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

	public void deleteUser(int id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call deleteuser(?)";
		CallableStatement call = conn.prepareCall(sql);
		
		call.setInt(1, id);
		call.execute();
		
		System.out.println("User Deleted");
	}

}
