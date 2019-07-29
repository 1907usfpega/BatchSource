package com.revature.driver;

import java.sql.SQLException;

import com.revature.dao.SuperheroDaoImpl;
import com.revature.dao.SuperpowerDaoImpl;

public class Driver {
	public static void main(String[] args) {
		SuperheroDaoImpl shdi = new SuperheroDaoImpl();
	/*	try {
			System.out.println(shdi.getSuperheroList());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SuperpowerDaoImpl sdi = new SuperpowerDaoImpl();
		try {
			sdi.createSuperpower("Heat Resistance" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		try {
			shdi.createSuperhero("badman");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
