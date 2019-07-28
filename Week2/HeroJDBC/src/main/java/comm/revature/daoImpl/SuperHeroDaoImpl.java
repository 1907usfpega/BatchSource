package comm.revature.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.SuperHero;
import com.revature.util.ConnFactory;

import comm.revature.dao.SuperHeroDao;

public class SuperHeroDaoImpl implements SuperHeroDao{
	public static ConnFactory cf= ConnFactory.getInstance();
	
	public void createSuperHero(String heroName) throws SQLException {
		Connection conn = cf.getConnection();
		String sql= "{call insertsuperhero(?)";
		CallableStatement call= conn.prepareCall(sql);
		call.setString(1, heroName);
		call.execute();
	}

	public List<SuperHero> getSuperHeroList() throws SQLException {
		List<SuperHero> superHeroList = new ArrayList<SuperHero>();
		Connection conn= cf.getConnection();
		//statement- compiled on SQL side; generally terrible
		//allows for SQLInjection 
		Statement stmt = conn.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT * FROM superhero");
		SuperHero s= null;
		while(rs.next()) {
			s= new SuperHero(rs.getInt(1),rs.getString(2));
			superHeroList.add(s);
		}
		return superHeroList;
	}

}
