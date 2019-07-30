package com.revature.driver;

import java.sql.SQLException;

import com.revature.daoimpl.SuperHeroDaoImpl;

public class Driver {

	public static void main(String[] args) {

		SuperHeroDaoImpl shdi = new SuperHeroDaoImpl();
		try {
			shdi.createSuperHero("Superman","Kryptonian (on Earth)");
			//shdi.createSuperHero("Blue Beetle","Alien Symbiote");
			/*
			 * shdi.createSuperHero("Bubbler","Snowglobing");
			 * shdi.createSuperHero("Megamind","Presentation");
			 * shdi.createSuperHero("Mariposa","Butterfly");
			 */
			//shdi.createSuperHero("One Punch Man");
			//System.out.println(shdi.getSuperHeroList());
		} catch (SQLException e) {
			// TODO Auto-generated catch block e.printStackTrace();
		}

		/*
		 * PowerDaoImpl pdi = new PowerDaoImpl(); try { //pdi.createPower("Flight");
		 * //pdi.createPower("Webslinging"); pdi.createPower("';--"); } catch
		 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */

	}// end main

}// end Driver
