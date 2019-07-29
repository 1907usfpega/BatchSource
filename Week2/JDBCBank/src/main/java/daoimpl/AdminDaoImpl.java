/**
 * 
 */
package daoimpl;

import java.sql.Connection;
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
	
	public Admin getCurrentAdmin() throws SQLException {
		Connection conn = cf.getConnection();
		return null;
	}

	public Admin getAdmin(int id) throws SQLException {
		Connection conn = cf.getConnection();
		return null;
	}

	public void updateAdmin(String firstname, String lastname) throws SQLException {
		Connection conn = cf.getConnection();

	}

}
