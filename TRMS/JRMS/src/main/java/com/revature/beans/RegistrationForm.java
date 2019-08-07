package com.revature.beans;

public class RegistrationForm {

	private String fName;
	private String lName;
	private String email;
	private String aStreet;
	private String aCity;
	private String aState;
	private int zCode;
	private String un;
	private String pw;
	public RegistrationForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RegistrationForm(String fName, String lName, String email, String aStreet, String aCity, String aState,
			int zCode, String un, String pw) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.aStreet = aStreet;
		this.aCity = aCity;
		this.aState = aState;
		this.zCode = zCode;
		this.un = un;
		this.pw = pw;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getaStreet() {
		return aStreet;
	}
	public void setaStreet(String aStreet) {
		this.aStreet = aStreet;
	}
	public String getaCity() {
		return aCity;
	}
	public void setaCity(String aCity) {
		this.aCity = aCity;
	}
	public String getaState() {
		return aState;
	}
	public void setaState(String aState) {
		this.aState = aState;
	}
	public int getzCode() {
		return zCode;
	}
	public void setzCode(int zCode) {
		this.zCode = zCode;
	}
	public String getUn() {
		return un;
	}
	public void setUn(String un) {
		this.un = un;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	@Override
	public String toString() {
		return "RegistrationForm [fName=" + fName + ", lName=" + lName + ", email=" + email + ", aStreet=" + aStreet
				+ ", aCity=" + aCity + ", aState=" + aState + ", zCode=" + zCode + ", un=" + un + ", pw=" + pw + "]";
	}
	
	
	
}
