package com.revature.driver;

import java.sql.SQLException;

<<<<<<< HEAD
import comm.revature.daoImpl.PowersDaoImpl;
import comm.revature.daoImpl.SuperHeroDaoImpl;
=======
import com.revature.daoimpl.PowersDaoImpl;
import com.revature.daoimpl.SuperHeroDaoImpl;
>>>>>>> a15aab9d093e1f080c0b12ad5656323dbb830291

public class Driver {

	public static void main(String[] args) {
<<<<<<< HEAD
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

=======
		System.out.println("roll tide");
		SuperHeroDaoImpl shdi = new SuperHeroDaoImpl();
		/*
		 * try { System.out.println(shdi.getSuperHeroList()); 
		 * } catch (SQLException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		PowersDaoImpl pdi= new PowersDaoImpl();
		try {
			//pdi.createPowers(";");
			shdi.createSuperHero("Onepunchman");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
>>>>>>> a15aab9d093e1f080c0b12ad5656323dbb830291
