package dao;

import java.sql.SQLException;

public interface PowerDao {

	public abstract void createPower(String powerName) throws SQLException;
	
}//end PowerDao interface
