package com.revature.beans;

public class Powers {

	private int PowersID;
	private String PowersName;
	
	public Powers() {
		// TODO Auto-generated constructor stub
	}

	public Powers(int powersID, String powersName) {
		super();
		PowersID = powersID;
		PowersName = powersName;
	}

	public int getPowersID() {
		return PowersID;
	}

	public void setPowersID(int powersID) {
		PowersID = powersID;
	}

	public String getPowersName() {
		return PowersName;
	}

	public void setPowersName(String powersName) {
		PowersName = powersName;
	}

	@Override
	public String toString() {
		return "Powers [PowersID=" + PowersID + ", PowersName=" + PowersName + "]";
	}
	
}
