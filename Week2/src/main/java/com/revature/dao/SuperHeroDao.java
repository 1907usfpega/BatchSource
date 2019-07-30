package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.SuperHero;

public interface SuperHeroDao {
	//for crud ops
	public abstract void createSuperHero(String name) throws SQLException;
	public abstract List<SuperHero> getSuperHeroList() throws SQLException;
}
