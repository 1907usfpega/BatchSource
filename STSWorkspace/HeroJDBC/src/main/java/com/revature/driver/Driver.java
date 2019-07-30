package com.revature.driver;

import java.sql.SQLException;

import com.revature.daoimpl.PowerDaoImpl;
import com.revature.daoimpl.SuperHeroDaoImpl;

public class Driver 
{
	
	public static void main(String[] args) 
	{
		SuperHeroDaoImpl shdi = new SuperHeroDaoImpl();
		PowerDaoImpl pdi = new PowerDaoImpl();
		
		try 
		{
			pdi.createPower("Flight");
			System.out.println(shdi.getSuperHeroList());
			//shdi.createSuperHero("Dog Welder");
			shdi.createSuperHeroWithPower("Flash Gordon", "Being Flashy");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

}
