package dao;

import java.sql.SQLException;

public interface AdminDao {

	public abstract void updateAdminName(String adminName, int adminID) throws SQLException;
	
}//end updateAdminName interface
