package daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.SuperHero;
import dao.SuperHeroDao;
import util.ConnectionFactory;

public class SuperHeroDaoImpl implements SuperHeroDao{

	public static ConnectionFactory cf = ConnectionFactory.getInstance();
	
	public void createSuperHero(String heroName) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call insert_hero(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, heroName);
		call.execute();
	}
	
	public void createSuperHeroAndPower(String powerName, String heroName) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call insert_hero_power(?,?)";  //<-- ? is input 
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, powerName);
		call.setString(2, heroName); //<--2 is the column
		call.execute();
	}


	public List<SuperHero> getSuperHeroList() throws SQLException {
		
		List<SuperHero> HeroList = new ArrayList<SuperHero>();
		Connection conn = cf.getConnection();
		
		//Statement - Compiled on SQL side, terrible, allows for SQL Injection
		//Prepared Statement - 
		//Callable Statement
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM hero");
		SuperHero s = null;
		while(rs.next()) {
			s = new SuperHero(rs.getInt(1), rs.getString(2));
			HeroList.add(s);
		}
		
		return HeroList;
	}

}//end SuperHeroDaoImpl class
