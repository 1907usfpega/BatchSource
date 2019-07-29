/**
 * 
 */
package admin;

/**
 * @author MajorKey
 *
 */
public class Admin {

	private int adminid;
	private String firstname;
	private String lastname;
	/**
	 * @param adminid
	 * @param firstname
	 * @param lastname
	 */
	public Admin(int adminid, String firstname, String lastname) {
		super();
		this.adminid = adminid;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	/**
	 * @param firstname
	 * @param lastname
	 */
	public Admin(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}
	/**
	 * 
	 */
	public Admin() {
		super();
	}
	/**
	 * @return the adminid
	 */
	public int getAdminid() {
		return adminid;
	}
	/**
	 * @param adminid the adminid to set
	 */
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	
	
}
