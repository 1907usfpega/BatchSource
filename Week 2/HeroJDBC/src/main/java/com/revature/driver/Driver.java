package com.revature.driver;

import java.sql.SQLException;

import com.revature.daoimpl.PowersDaoImpl;
import com.revature.daoimpl.SuperHeroDaoImpl;

public class Driver {

	public static void main(String [] args) {
		SuperHeroDaoImpl shdi = new SuperHeroDaoImpl();
//		try {
//			System.out.println(shdi.getSuperHeroList());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		PowersDaoImpl pdi = new PowersDaoImpl();
		try {
//			pdi.createPowers("Shoot Web");
//			shdi.createSuperHero("Iron Man");
			shdi.createNewHeroAndPower("Thor", "Conjure Lightning");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
