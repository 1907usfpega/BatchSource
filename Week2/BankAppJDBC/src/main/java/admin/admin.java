
package Admin;


public class Admin {

	private int adminid;
	private String firstname;
	private String lastname;
	
	public Admin(int adminid, String firstname, String lastname) {
		super();
		this.adminid = adminid;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public Admin(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public Admin() {
		super();
	}
	
	public int getAdminid() {
		return adminid;
	}
	
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	
	
}