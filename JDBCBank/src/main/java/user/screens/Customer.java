package user.screens;

public class Customer {

	private int customerID;
	private int userID;
	private String customerName;
	
	
	public Customer() {
		super();
		
	}


	public Customer(int customerID, int userID, String customerName) {
		super();
		this.customerID = customerID;
		this.userID = userID;
		this.customerName = customerName;
	}


	public int getCustomerID() {
		return customerID;
	}


	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}


	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", userID=" + userID + ", customerName=" + customerName + "]";
	}
	
	
}//end Customer class

