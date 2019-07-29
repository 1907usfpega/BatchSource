package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Superhero;
import com.revature.util.ConnFactory;

public class SuperheroDaoImpl implements SuperheroDao{
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void createSuperhero(String heroName) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call INSERTSUPERHERO(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, heroName);
		call.execute();
	}

	public List<Superhero> getSuperheroList() throws SQLException {
		List<Superhero> superheroList = new ArrayList<Superhero>();
		Connection conn = cf.getConnection(); 		
		//Statement - compiled on SQL-side; generally terrible. Allows for SQL-Injection
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM superhero");
		Superhero s = null;
		while(rs.next()) {
			s = new Superhero(rs.getInt(1), rs.getString(2));
			superheroList.add(s);
		}
		return superheroList;
	}
	


}
