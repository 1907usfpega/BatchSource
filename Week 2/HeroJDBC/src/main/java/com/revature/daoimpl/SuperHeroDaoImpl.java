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

public class SuperHeroDaoImpl implements SuperHeroDao {

	public static ConnFactory cf = ConnFactory.getInstance();
	
	public SuperHeroDaoImpl() {
		// TODO Auto-generated constructor stub
		super();
	}

	public void createSuperHero(String heroName) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call INSERTSUPERHERO(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, heroName);
		call.execute();
	}
	
	public List<SuperHero> getSuperHeroList() throws SQLException {
		// TODO Auto-generated method stub
		List<SuperHero> superHeroList = new ArrayList<SuperHero>();
		Connection conn = cf.getConnection();
		// Statement - compiled on SQL side; generally terrible
		// Allows for SQLInjection
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM SUPERHERO");
		SuperHero s = null;
		while (rs.next()) {
			s = new SuperHero(rs.getInt(1), rs.getString(2));
			superHeroList.add(s);
		}
		
		return superHeroList;
	}

	
	
}
