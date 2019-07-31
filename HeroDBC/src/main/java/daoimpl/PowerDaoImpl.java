package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.PowerDao;
import util.ConnectionFactory;

public class PowerDaoImpl implements PowerDao{

	public static ConnectionFactory cf = ConnectionFactory.getInstance();
	
	public void createPower(String powerName) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO superpower VALUES(power_seq.NEXTVAL,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, powerName);
		ps.executeUpdate();
		
	}

}
