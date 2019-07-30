package com.revature.driver;

import java.sql.SQLException;

import com.revature.daoimpl.FullDao;
//import com.revature.daoimpl.PowersDaoImpl;
//import com.revature.daoimpl.SuperHeroDaoImpl;

public class Driver {

	public static void main(String[] args) {
		//boolean quit=false;
		//Scanner sc = new Scanner(System.in);
		//SuperHeroDaoImpl shdi = new SuperHeroDaoImpl();
		//PowersDaoImpl pdi = new PowersDaoImpl();

		//while (!quit) {
			//String s = sc.nextLine();

		FullDao fd= new FullDao();
		
		try {
			fd.createHeroPower("The Flash", "Fast");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*	try {
				shdi.createSuperHero("");
				// System.out.println(shdi.getSuperHeroList());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				pdi.createPowers("Spider");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
	}

}
