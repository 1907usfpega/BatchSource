package daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.AdminDao;
import util.ConnectionFactory;

public class AdminDaoImpl implements AdminDao{

	public static ConnectionFactory cf = ConnectionFactory.getInstance();

	//--------------------------------------Get AdminID-----------------------------------------------------
	public int getAdminID(int userID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT admin_id FROM bank_admin WHERE fk_user_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, userID);
		ResultSet rs = ps.executeQuery();
		int testID = 0;
		if(rs.next()) {
			testID = rs.getInt(1);
		}
		return testID;
	}//end getAdminID()
	
	
	//--------------------------------------Get Admin Name-----------------------------------------------------
	public String getAdminName(int userID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT admin_name FROM admin WHERE fk_user_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, userID);
		ResultSet rs = ps.executeQuery();
		String testName= "";
		if(rs.next()) {
			testName = rs.getString(1);
		}
		return testName;
	}//end getAdminName()
	
	
	//--------------------------------------Update Admin Name-----------------------------------------------------
	public void updateAdminName(String adminName, int userID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call update_customer_name(?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, adminName);
		call.setInt(2, userID);
		call.execute();
	}//end updateCustomerName()

}//end AdminDaoImpl class
