package user.screens;

public class Admin {

	private int adminID;
    private int userID;
    private String adminName;
	
    
    public Admin() {
		super();
		
	}


	public Admin(int adminID, int userID, String adminName) {
		super();
		this.adminID = adminID;
		this.userID = userID;
		this.adminName = adminName;
	}


	public int getAdminID() {
		return adminID;
	}


	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}


	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	public String getAdminName() {
		return adminName;
	}


	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}


	@Override
	public String toString() {
		return "Admin [adminID=" + adminID + ", userID=" + userID + ", adminName=" + adminName + "]";
	}
    

	
}//end Admin class
