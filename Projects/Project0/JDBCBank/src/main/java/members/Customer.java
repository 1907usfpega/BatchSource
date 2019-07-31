package members;

public class Customer extends BankUser {
	private int userid;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	

	
	
	
	
}
