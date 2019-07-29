package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Superhero;

public interface SuperheroDao {
	//CRUD ops
	public abstract void createSuperhero(String heroname) throws SQLException;
	public abstract List<Superhero> getSuperheroList() throws SQLException;
	
}
