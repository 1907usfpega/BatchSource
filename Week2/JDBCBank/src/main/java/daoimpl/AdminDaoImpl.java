/**
 * 
 */
package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import admin.Admin;
import dao.IAdminDao;
import util.ConnFactory;

/**
 * @author MajorKey
 *
 */
public class AdminDaoImpl implements IAdminDao {

	public static ConnFactory cf = ConnFactory.getInstance();

	//gets an admin from the db
	public Admin getAdmin(int id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "Select * FROM admin WHERE adminid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Admin a = null;
		
		while(rs.next()) {
			a = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3));
		}
		
		return a;
	}

}
