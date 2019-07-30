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
	
	public void createSuperHero(String name) throws SQLException {
		//callable statement
		Connection conn=cf.getConnection();
		String sql="{ call insertsuperhero(?)";
		CallableStatement cs=conn.prepareCall(sql);
		cs.setString(1, name);
		cs.executeUpdate();
	}

	public List<SuperHero> getSuperHeroList() throws SQLException {
		List<SuperHero> team=new ArrayList<SuperHero>();
		Connection conn =cf.getConnection();
		//statement - compiled on sequel side; generally terrible (allows for sql injection)
		//prepared statement- compiled on code side; 
		//call-able statement- compiled on code side; 
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from superhero");
		SuperHero s=null;
		while(rs.next()) {
			s=new SuperHero(rs.getInt(1),rs.getString(2));
			team.add(s);
		}
		return team;
	}

}
