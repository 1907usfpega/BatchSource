package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.bean.ZipCode;

public class ZipCodeDaoImpl {
	public static List<ZipCode> zipList = new ArrayList<ZipCode>();
	static {
		zipList.add( new ZipCode(33579, "Riverview", "Florida"));
		zipList.add( new ZipCode(33559, "Lutz", "Florida"));
		zipList.add( new ZipCode(92277, "Twentynine Palms", "California"));
		zipList.add( new ZipCode(35670, "Somerville", "Alabama"));
	}
	
	//CRUD OPS
	public static List<ZipCode> getAllZipCodes(){
		return zipList;
	}
	
	public static ZipCode getInfoByZip(int zipcode) {
		for (ZipCode z: zipList) {
			if(z.getZipCode()==zipcode) {
				return z;
			}
		} return null;
		
	}
	
	public static void addZipCode(ZipCode z) {
		zipList.add(z);
	}
	
	public static void removeZipCode(int zipcode) {
		for(int i = 0; i<zipList.size(); i++) {
			if(zipList.get(i).getZipCode()==zipcode) {
				zipList.remove(i);
				break;
			}
		}
	}
}
