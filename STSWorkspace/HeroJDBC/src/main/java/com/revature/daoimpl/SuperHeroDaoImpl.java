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

public class SuperHeroDaoImpl implements SuperHeroDao
{
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void createSuperHero(String heroName) throws SQLException 
	{
		Connection conn = cf.getConnection();
		String sql = "{ call INSERTSUPERHERO(?)";
		//callable statement
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, heroName);
		call.execute();
	}
	
	public void createSuperHeroWithPower(String heroName, String powerName) throws SQLException 
	{
		Connection conn = cf.getConnection();
		String sql = "{ call CREATEHEROANDPOWER(?, ?)";
		//callable statement
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, heroName);
		call.setString(2, powerName);
		call.execute();
	}

	public List<SuperHero> getSuperHeroList() throws SQLException 
	{
		List<SuperHero> heroList = new ArrayList<SuperHero>();
		Connection conn = cf.getConnection();
	   /* Statement: compiled on SQL side; generally terrible; allows for SQL injection(muy mal)
		* Prepared Statement: 
		* Called Statement
		*/
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM SUPERHERO");
		SuperHero s = null;
		while(rs.next())
		{
			s = new SuperHero(rs.getInt(1), rs.getString(2));
			heroList.add(s);
		}
		return heroList;
	}
	
}
