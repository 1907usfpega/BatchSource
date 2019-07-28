package com.revature.driver;

import java.sql.SQLException;

import comm.revature.daoImpl.PowersDaoImpl;
import comm.revature.daoImpl.SuperHeroDaoImpl;

public class Driver {

	public static void main(String[] args) {
		SuperHeroDaoImpl sdhi = new SuperHeroDaoImpl();
		
		 // try {
	
			//System.out.println(sdhi.getSuperHeroList());
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
		//e.printStackTrace();
		PowersDaoImpl pdi= new PowersDaoImpl();
		try {
			// pdi.createPowers("Strength");
			sdhi.createSuperHero("Twopunchman");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}

	}

