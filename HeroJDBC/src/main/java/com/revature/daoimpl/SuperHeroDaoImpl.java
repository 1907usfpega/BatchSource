package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.SuperHero;
import com.revature.dao.SuperHeroDao;
import com.revature.util.ConnFactory;

public class SuperHeroDaoImpl implements SuperHeroDao{
	public static ConnFactory cf = ConnFactory.getInstance();
	

	public void createSuperHero(String heroName) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call insert_superhero(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, heroName);
		call.execute();
	}//end createSuperHero

	public List<SuperHero> getSuperHeroList() throws SQLException {
		List<SuperHero> superHeroList = new ArrayList<SuperHero>();
		Connection conn = cf.getConnection();
		//Statement - compiled on SQL side; generally terrible (allows for SQL injection) but since we're hardcoding it in, it's ok
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM superhero");//no need for semicolon
		SuperHero s = null;
		while(rs.next()) {
			s = new SuperHero(rs.getInt(1),rs.getString(2));
			superHeroList.add(s);
		}
		return superHeroList;
	}//end getSuperHeroList
	
	public void createSuperHero(String heroName, String powerName) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call insert_hero_and_power(?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, heroName);
		call.setString(2, powerName);
		call.execute();
	}//end createSuperHero(String heroName, String powerName)

	
}//end SuperHero DaoImpl
