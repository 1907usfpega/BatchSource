package com.revature.dao;

import java.util.List;
import java.util.ArrayList;

import com.revature.bean.ZipCode;

public class ZipCodeDaoImpl {
	public static List<ZipCode> ziplist=new ArrayList<ZipCode>();
	static {
		ziplist.add( new ZipCode(33579, "Riverview","Florida"));
		ziplist.add( new ZipCode(33559, "Lutz","Florida"));
		ziplist.add( new ZipCode(92277, "Twentynine Palms","California"));
		ziplist.add( new ZipCode(35670, "Somerville","Alabama"));
	}
	//crud ops
	public static List<ZipCode> getAllZipCodes(){
		return ziplist;
	}
	public static ZipCode getInfoByZip(int zipcode) {
		for(ZipCode z: ziplist) {
			if(z.getZipCode()==zipcode) {
				return z;
			}
			
		}
		return null;
		
	}
	public static void addZipCode(ZipCode z) {
		ziplist.add(z);
	}
	public static void removeZipCode(int zipcode) {
		for (int i=0;i<ziplist.size(); i++) {
			if(ziplist.get(i).getZipCode()==zipcode) {
				ziplist.remove(i);
				i--;// so we dont go out of bounds
				break;
			}
		}
	}
}
