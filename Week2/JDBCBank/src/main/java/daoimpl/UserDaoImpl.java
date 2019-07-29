/**
 * 
 */
package daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		/*String sql = "{call get_user(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, id);
		ResultSet rs = call.executeQuery();
		User user = null;
		
		while(rs.next()) {
			user = new User(rs.getInt(1),rs.getString(2),rs.getString(3));
		}
		
		return user;*/
		return null;
	}

	public List<User> getAllUsers() throws SQLException {
		Connection conn = cf.getConnection();
		return null;
	}

	public void updateUser(int id, String firstname, String lastname) throws SQLException {
		Connection conn = cf.getConnection();

	}

	public void deleteUser(int id) throws SQLException {
		Connection conn = cf.getConnection();

	}

}
