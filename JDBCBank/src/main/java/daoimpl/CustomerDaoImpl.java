package daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.CustomerDao;
import util.ConnectionFactory;

public class CustomerDaoImpl implements CustomerDao{

	public static ConnectionFactory cf = ConnectionFactory.getInstance();

	public void updateCustomerName(String customerName, int customerID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call update_customer_name(?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, customerName);
		call.setInt(2, customerID);
		call.execute();
		
	}//end updateCustomerName()

	
	public int getCustomerID(int userID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT customer_id FROM customer WHERE fk_user_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, userID);
		ResultSet rs = ps.executeQuery();
		int testID = 0;
		if(rs.next()) {
			testID = rs.getInt(1);
		}
		return testID;
	}//end getCustomerID()


	public String getCustomerName(int userID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT customer_name FROM customer WHERE fk_user_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, userID);
		ResultSet rs = ps.executeQuery();
		String testName= "";
		if(rs.next()) {
			testName = rs.getString(1);
		}
		return testName;
	}//end getCustomerName()
	
}//end CustomerDaoImpl class
