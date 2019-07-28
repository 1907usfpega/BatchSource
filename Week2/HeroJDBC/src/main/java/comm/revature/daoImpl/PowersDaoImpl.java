package comm.revature.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.util.ConnFactory;

import comm.revature.dao.PowerDao;

public class PowersDaoImpl implements PowerDao{
	public static ConnFactory cf= ConnFactory.getInstance();

	public void createPowers(String powerName) throws SQLException {
		Connection conn= cf.getConnection();
		String sql= "INSERT INTO POWERS VALUES(powerseq.NEXTVAL,?)";
		PreparedStatement ps= conn.prepareStatement(sql);
		ps.setString(1, powerName);
		ps.executeUpdate();
	}
	
}
