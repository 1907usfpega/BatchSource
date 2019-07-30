package com.revature.beans;

public class Power 
{
	private int powerID;
	private String powerName;
	
	public Power(int powerID, String powerName) 
	{
		super();
		this.powerID = powerID;
		this.powerName = powerName;
	}

	public int getPowerID() 
	{
		return powerID;
	}

	public void setPowerID(int powerID) 
	{
		this.powerID = powerID;
	}

	public String getPowerName() 
	{
		return powerName;
	}

	public void setPowerName(String powerName) 
	{
		this.powerName = powerName;
	}

	@Override
	public String toString() 
	{
		return "Power [powerID=" + powerID + ", powerName=" + powerName + "]";
	}	
}
