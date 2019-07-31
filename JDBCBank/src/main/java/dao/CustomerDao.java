package dao;

import java.sql.SQLException;

public interface CustomerDao {
	
	public abstract int getCustomerID(int userID) throws SQLException;
	
	public abstract String getCustomerName(int userID) throws SQLException;
	
	public abstract void updateCustomerName(String customerName, int userID) throws SQLException;
	
}//end updateCustomerName interface
