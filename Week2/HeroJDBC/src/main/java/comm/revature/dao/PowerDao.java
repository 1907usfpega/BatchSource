package comm.revature.dao;

import java.sql.SQLException;

public interface PowerDao {
	public abstract void createPowers(String powerName) throws SQLException;
}
