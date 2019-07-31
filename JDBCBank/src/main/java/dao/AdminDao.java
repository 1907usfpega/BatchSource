package dao;

import java.sql.SQLException;

public interface AdminDao {

	public abstract int getAdminID(int userID) throws SQLException;

	public abstract String getAdminName(int userID) throws SQLException;
	
	public abstract void updateAdminName(String adminName, int userID) throws SQLException;

}//end updateAdminName interface
