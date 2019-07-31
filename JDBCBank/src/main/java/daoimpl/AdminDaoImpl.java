package daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import dao.AdminDao;
import util.ConnectionFactory;

public class AdminDaoImpl implements AdminDao{

	public static ConnectionFactory cf = ConnectionFactory.getInstance();

	
	public void updateAdminName(String adminName, int adminID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call update_admin_name(?,?);";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, adminName);
		call.setInt(2, adminID);
		call.execute();
		
	}//end updateAdminName()

}//end AdminDaoImpl class
