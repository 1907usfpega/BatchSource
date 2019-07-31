package driver;

import java.sql.SQLException;

import daoimpl.PowerDaoImpl;
import daoimpl.SuperHeroDaoImpl;

public class Driver {

	public static void main(String[] args) {
		
		SuperHeroDaoImpl shdi = new SuperHeroDaoImpl();
		try {
			shdi.createSuperHeroAndPower("Speedy", "Gonzales");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		PowerDaoImpl pdi = new PowerDaoImpl();
		
//		
//		try {
//			//pdi.createPower("Flight");
//			//shdi.createSuperHero("Captain Obvious");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
	}//end main

}//end Driver class
